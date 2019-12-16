package cn.wangx.DriverTest.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtils {
    /**
     * 定义需要的变量
     */
    private static Connection connection = null;
    /**
     * 在大多情况下，我们使用的是PrepardStatement 来代替Statement
     * 这样可以防止sql注入
     */
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;

    /**
     * 连接数据库参数
     */
    private static String username = null;
    private static String password = null;
    private static String driver = null;
    private static String url = null;

    /**
     * 加载驱动，只需一次
     */
    static {
        try {
            username = "driver";
            password = "driver";
            driver = "com.mysql.cj.jdbc.Driver";
            url = "jdbc:mysql://mysql.wangxinsheng.cn:3306/driver?characterEncoding=utf8&useSSL=false";
            Class.forName(driver);
        } catch (Exception e) {
            System.err.println("连接失败，请检查连接参数");
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接
     * @return 返回Connection
     */
    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            System.err.println("获取连接失败");
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 查询语句
     * @param sql sql语句
     * @param parms 占位符参数数组
     * @return 返回List<Object[]>
     */
    public static List<Object[]> select(String sql, String[] parms) {
        try {
            //获取连接
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            //对sql中的占位符进行赋值
            setPreparedStatement(parms);
            //获得结果集合
            resultSet = preparedStatement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            //定义List存放每行数据
            List<Object[]> objectList = new ArrayList<>();
            //获取列数
            int columnCount = metaData.getColumnCount();
            //对结果集合进行遍历并将每行的数据存入Object[]中
            while (resultSet.next()) {
                //对象数组，表示一行数据
                Object[] objects = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    objects[i - 1] = resultSet.getObject(i);
                }
                //将数组存入list
                objectList.add(objects);
            }
            return objectList;
        } catch (Exception e) {
            System.err.println("查询失败！");
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    /**
     * 可处理insert/delete/update语句
     * @param sql sql语句
     * @param parms 占位符参数数组
     * @return 返回bool值，表示是否成功
     */
    public static boolean addOrInsertOrUpdate(String sql, String[] parms){

        try {
            //获取连接
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            //对占位符进行赋值
            setPreparedStatement(parms);
            //提交sql
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e){
            System.err.println("表更新失败!");
            e.printStackTrace();
        } finally {
            close();
        }
        return false;
    }

    /**
     * 对sql语句中的占位符进行赋值
     * @param parms 参数值
     * @throws SQLException sql异常
     */
    private static void setPreparedStatement(String[] parms) throws SQLException {
        if (parms != null && parms.length > 0) {
            for (int i = 0; i < parms.length; i++) {
                if("null".equals(parms[i])){
                    preparedStatement.setNull(i + 1, Types.NULL);
                }else {
                    preparedStatement.setString(i + 1, parms[i]);
                }
            }
        }
    }

    /**
     * 关闭资源的函数
     */
    public static void close() {
        if(resultSet != null) {
            try {
                resultSet.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            resultSet = null;
        }
        if(preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            preparedStatement = null;
        }
        if(connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            connection = null;
        }
    }

}
