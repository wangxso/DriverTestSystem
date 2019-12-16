package cn.wangx.DriverTest.dao.impl;

import cn.wangx.DriverTest.dao.ExamDao;
import cn.wangx.DriverTest.pojo.Exam;
import cn.wangx.DriverTest.util.DBUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExamDaoImpl implements ExamDao {
    Connection connection = DBUtils.getConnection();
    Logger logger = LoggerFactory.getLogger(ExamDaoImpl.class);
    @Override
    public List<Exam> findExamByUid(String uid) {
        String sql = "select * from exam where uid = ?";
        List<Exam> examList = new ArrayList<>();
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,uid);
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()){
                Exam exam = new Exam(resultSet.getString("uid"),
                        resultSet.getInt("pass"),resultSet.getInt("fail"),
                        resultSet.getString("pid_list"),resultSet.getString("date"));
                examList.add(exam);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close();
        }
        return examList;
    }

    @Override
    public int addExam(Exam exam) {
        String sql = "insert into exam(uid,pass,fail,pid_list,date) values(?,?,?,?,?)";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1,exam.getUid());
            pst.setInt(2,exam.getPass());
            pst.setInt(3,exam.getFail());
            pst.setString(4,exam.getPid_list());
            pst.setString(5,exam.getDate());
            pst.execute();
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
