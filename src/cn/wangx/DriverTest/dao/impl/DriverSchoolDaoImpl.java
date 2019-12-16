package cn.wangx.DriverTest.dao.impl;

import cn.wangx.DriverTest.dao.DriverSchoolDao;
import cn.wangx.DriverTest.pojo.DriverSchool;
import cn.wangx.DriverTest.util.DBUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DriverSchoolDaoImpl implements DriverSchoolDao {
    Connection connection = null;
    private final Logger logger = LoggerFactory.getLogger(DriverSchool.class);
    @Override
    public List<DriverSchool> findDriverSchoolPagination(int start, int end) {
        connection = DBUtils.getConnection();
        List<DriverSchool> driverSchools = new ArrayList<>();
        String sql = "select * from driver_school limit ?,?";

        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1,start);
            pst.setInt(2,end);
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()){
                DriverSchool driverSchool = new DriverSchool(resultSet.getInt("sid"),
                        resultSet.getString("title"),
                        resultSet.getInt("price"),
                        resultSet.getString("address"),
                        resultSet.getString("phone"),
                        resultSet.getString("city"),
                        resultSet.getString("src")
                        );
                driverSchools.add(driverSchool);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close();
        }


        return driverSchools;
    }

    @Override
    public int findDriverSchoolNumber() {
        connection = DBUtils.getConnection();
        int res = 0;
        String sql = "select count(0) from driver_school";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()){
                res = Integer.parseInt(resultSet.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public DriverSchool findDriverSchoolById(int id) {
        connection = DBUtils.getConnection();
        DriverSchool driverSchool = null;
        String sql = "select * from driver_school where sid = ?";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1,id);
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()){
                driverSchool = new DriverSchool(resultSet.getInt("sid"),
                        resultSet.getString("title"),
                        resultSet.getInt("price"),
                        resultSet.getString("address"),
                        resultSet.getString("phone"),
                        resultSet.getString("city"),
                        resultSet.getString("src")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return driverSchool;
    }
}
