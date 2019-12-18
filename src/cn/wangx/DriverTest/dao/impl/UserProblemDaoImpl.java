package cn.wangx.DriverTest.dao.impl;

import cn.wangx.DriverTest.dao.UserProblemDao;
import cn.wangx.DriverTest.pojo.UserProblem;
import cn.wangx.DriverTest.util.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserProblemDaoImpl implements UserProblemDao {
    Connection connection;
    @Override
    public int addUserProblem(UserProblem userProblem) {
        connection = DBUtils.getConnection();
        String sql = "insert into user_problem(uid,pid,status,type,mode) values(?,?,?,?,?)";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,userProblem.getUid());
            pst.setInt(2,userProblem.getPid());
            pst.setInt(3,userProblem.getStatus());
            pst.setInt(4,userProblem.getType());
            pst.setInt(5,userProblem.getMode());
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
    public int updateUserProblem(UserProblem userProblem) {
        connection = DBUtils.getConnection();
        String sql = "update user_problem set uid=?,pid=?.status=?,type=?,mode=?";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,userProblem.getUid());
            pst.setInt(2,userProblem.getPid());
            pst.setInt(3,userProblem.getStatus());
            pst.setInt(4,userProblem.getType());
            pst.setInt(5,userProblem.getMode());
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
    public List<UserProblem> findUserProblemByUid(String uid) {
        List<UserProblem> userProblemList = new ArrayList<>();
        connection = DBUtils.getConnection();
        String sql = "select uid,pid,status,type,mode from user_problem where uid = ?";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,uid);
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()){
                UserProblem userProblem = new UserProblem(
                        resultSet.getString("uid"),
                        resultSet.getInt("pid"),
                        resultSet.getInt("status"),
                        resultSet.getInt("type"),
                        resultSet.getInt("mode")
                );
                userProblemList.add(userProblem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userProblemList;
    }

    @Override
    public List<UserProblem> findUserProblemByPid(int pid) {
        List<UserProblem> userProblemList = new ArrayList<>();
        connection = DBUtils.getConnection();
        String sql = "select uid,pid,status,type,mode from user_table where pid = ?";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1,pid);
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()){
                UserProblem userProblem = new UserProblem(
                        resultSet.getString("uid"),
                        resultSet.getInt("pid"),
                        resultSet.getInt("status"),
                        resultSet.getInt("type"),
                        resultSet.getInt("mode")
                );
                userProblemList.add(userProblem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userProblemList;
    }
}
