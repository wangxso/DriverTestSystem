package cn.wangx.DriverTest.dao.impl;

import cn.wangx.DriverTest.dao.UserDao;
import cn.wangx.DriverTest.pojo.User;
import cn.wangx.DriverTest.pojo.UserProfile;
import cn.wangx.DriverTest.pojo.UserVisited;
import cn.wangx.DriverTest.util.DBUtils;
import org.apache.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.print.attribute.standard.PresentationDirection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private Connection connection;
    Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
    @Override
    public User findUserById(String uid) {
        String sql = "select * from user where uid=?";
        try {
            connection = DBUtils.getConnection();
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,uid);
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()){
                return new User(resultSet.getString("uid"),resultSet.getString("username"),resultSet.getString("password")
                        ,resultSet.getString("role"),resultSet.getString("r_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User findUserByUsername(String username) {
        try {
            connection = DBUtils.getConnection();
            String sql = "select * from user where username=?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,username);
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()){
                return new User(resultSet.getString("uid"),resultSet.getString("username"),resultSet.getString("password")
                        ,resultSet.getString("role"),resultSet.getString("r_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close();
        }
        return null;
    }

    @Override
    public List<User> findAllUser() {
        List<User> userList = new ArrayList<>();
        try {
            connection = DBUtils.getConnection();
            String sql = "select * from user";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()){
                User user = new User(resultSet.getString("uid"),resultSet.getString("username"),resultSet.getString("password")
                        ,resultSet.getString("role"),resultSet.getString("r_id"));
                user.setCreateDate(resultSet.getString("create_date"));
                user.setUpdateDate(resultSet.getString("update_date"));
            }
            return userList;
        } catch (SQLException e) {
            return null;
        }finally {
            DBUtils.close();
        }
    }

    @Override
    public int deleteUserById(String uid) {
        return 0;
    }

    @Override
    public int updateUser(User user)  {
        try {
            connection = DBUtils.getConnection();
            String sql = "INSERT INTO user VALUES (?,?,?,?,?,?,?)";
            PreparedStatement  pst = connection.prepareStatement(sql);
            pst.setString(1,user.getUid());
            pst.setString(2,null);
            pst.setString(3,user.getUsername());
            pst.setString(4,user.getPassword());
            pst.setString(5,user.getRole());
            pst.setString(6,user.getCreateDate());
            pst.setString(7,user.getUpdateDate());
            int i = pst.executeUpdate();
            logger.info(i+"行被影响"+" add user");
            logger.info(user.toString());
            connection.close();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }finally {
            DBUtils.close();
        }
    }


    @Override
    public int findAllUserNumber() {
        try {
            connection = DBUtils.getConnection();
            String sql = "select count(0) from user";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet resultSet = pst.executeQuery();
            int number = 0;
            while (resultSet.next()){
                String n = resultSet.getString(1);
                number = Integer.parseInt(n);
            }
            return  number;
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close();
        }
        return 0;
    }

    @Override
    public int addUserVisitedHistory(UserVisited userVisited) {
        connection = DBUtils.getConnection();
        String sql = "insert into user_login(username,ip,browser,visit_date) values(?,?,?,?)";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,userVisited.getUsername());
            pst.setString(2,userVisited.getIp());
            pst.setString(3,userVisited.getBrowser());
            pst.setString(4,userVisited.getDate());
            pst.executeUpdate();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close();
        }
        return 0;
    }

    @Override
    public int findUserVisitedNumber() {
        connection = DBUtils.getConnection();
        String sql = "select count(0) from user_login";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet resultSet = pst.executeQuery();
            int res = 0;
            while (resultSet.next()){
                String s = resultSet.getString(1);
                res = Integer.parseInt(s);
            }
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close();
        }
        return 0;
    }

    @Override
    public List<User> findUserByPagination(int start, int end) {
        connection = DBUtils.getConnection();
        List<User> userList = new ArrayList<>();
        try {
            String sql = "select * from user limit ?,?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1,start);
            pst.setInt(2,end);
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()){
                User user = new User(resultSet.getString("uid"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("role"),
                        resultSet.getString("r_id"),
                        resultSet.getString("create_date"),
                        resultSet.getString("update_date")
                );
                userList.add(user);
            }
            logger.info("用户分页查询 from "+start+" to "+ end);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close();
        }
        return userList;
    }

    @Override
    public List<UserVisited> findAllUserVisited() {
        List<UserVisited> userVisitedList = new ArrayList<>();
        connection = DBUtils.getConnection();
        String sql = "select * from user_login";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()){
                UserVisited userVisited = new UserVisited();
                userVisited.setUsername(resultSet.getString("username"));
                userVisited.setBrowser(resultSet.getString("browser"));
                userVisited.setDate(resultSet.getString("visit_date"));
                userVisited.setIp(resultSet.getString("ip"));
                userVisitedList.add(userVisited);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close();
        }
        return userVisitedList;
    }

    @Override
    public int addUserProfile(UserProfile userProfile) {
        connection = DBUtils.getConnection();
        String sql = "insert into user_profile(uid, real_name ,pass_number,fail_number) values (?,?,?,?)";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,userProfile.getUid());
            pst.setString(2,userProfile.getRealName());
            pst.setInt(3,userProfile.getPassNumber());
            pst.setInt(4,userProfile.getFailNumber());
            pst.execute();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close();
        }
        return 0;
    }

    @Override
    public UserProfile findUserProfileByUid(String uid) {
        connection = DBUtils.getConnection();
        String sql = "select * from user_profile where uid = ?";
        UserProfile userProfile = null;
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,uid);
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()){
               userProfile = new UserProfile(resultSet.getString("uid"),resultSet.getString("real_name"),
                        resultSet.getInt("pass_number"),resultSet.getInt("fail_number"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close();
        }
        return userProfile;
    }

    @Override
    public int updateUserProfile(UserProfile userProfile) {
        connection = DBUtils.getConnection();
        String sql = "update user_profile set real_name=?,pass_number=?,fail_number=? where uid=?";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,userProfile.getRealName());
            pst.setInt(2,userProfile.getPassNumber());
            pst.setInt(3,userProfile.getFailNumber());
            pst.setString(4,userProfile.getUid());
            pst.executeUpdate();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close();
        }
        return 0;
    }
}
