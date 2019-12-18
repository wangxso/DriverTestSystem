package cn.wangx.DriverTest.dao.impl;

import cn.wangx.DriverTest.dao.ProblemDao;
import cn.wangx.DriverTest.pojo.Problem;
import cn.wangx.DriverTest.util.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProblemDaoImpl implements ProblemDao {
//    Logger logger = Logger.getLogger(ProblemDaoImpl.class);
    @Override
    public Problem findProblemById(Long pid) {
        try {
            Problem problem = new Problem();
            String sql = "select * from problem where pid=?";
            String[] params = new String[1];
            params[0] = pid+"";
            List<Object[]> select = DBUtils.select(sql, params);
            for (Object[] ol: select){
                Integer pidd = (Integer) ol[0];
                problem.setPid(Long.parseLong(pidd.toString()));
                problem.setContent((String) ol[1]);
                problem.setResult((String) ol[2]);
                problem.setType((String) ol[3]);
                Integer pass = (Integer) ol[4];
                Integer submit = (Integer) ol[5];
                problem.setPass(pass);
                problem.setSubmit(submit);
                problem.setChooseItem((String) ol[6]);
                problem.setImg((String) ol[7]);
                problem.setMode((Integer) ol[8]);
            }
            return problem;
        }catch (NullPointerException e){
            return null;
        }
    }

    @Override
    public List<Problem> findProblemByIds(Long[] pids) {
        List<Problem> problemList = new ArrayList<>();
        for(Long pid: pids){
            problemList.add(findProblemById(pid));
        }
        return problemList;
    }

    @Override
    public List<Problem> findProblemWithModeAndType(String type, Integer mode) {
        List<Problem> problemList = new ArrayList<>();
        String sql = "select * from problem where type=? and mode=?";
        String[] params = new String[2];
        params[0] = type;
        params[1] = mode.toString();
        List<Object[]> select = DBUtils.select(sql, params);
        for (Object[] ol:select){
            Problem problem = new Problem();
            Integer pidd = (Integer) ol[0];
            problem.setPid(Long.parseLong(pidd.toString()));
            problem.setContent((String) ol[1]);
            problem.setResult((String) ol[2]);
            problem.setType((String) ol[3]);
            Integer pass = (Integer) ol[4];
            Integer submit = (Integer) ol[5];
            problem.setPass(pass);
            problem.setSubmit(submit);
            problem.setChooseItem((String) ol[6]);
            problem.setImg((String) ol[7]);
            problem.setMode((Integer) ol[8]);
            problemList.add(problem);
        }
        return problemList;
    }

    @Override
    public int updateProblem(Problem problem) {
        return 0;
    }

    @Override
    public int deleteProblemById(Long pid) {
        return 0;
    }

    @Override
    public int deleteProblemByIds(Long[] pids) {
        return 0;
    }

    @Override
    public int findProblemNumbers() {
        Connection connection = DBUtils.getConnection();
        String res = null;
        String sql = "select count(0) from problem";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()){
                res = resultSet.getString(1);
                int number = Integer.valueOf(res);
                return number;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 抽取出分页中的公共部分即查询添加
     * @param pst
     * @return
     * @throws SQLException
     */
    private List<Problem> pagination(PreparedStatement pst) throws SQLException {
        List<Problem> problemList = new ArrayList<>();
        ResultSet resultSet = pst.executeQuery();
        while (resultSet.next()){
            Problem problem = new Problem(resultSet.getLong("pid"),
                    resultSet.getString("content"),
                    resultSet.getString("choose_item"),
                    resultSet.getString("result"),
                    resultSet.getString("type"),
                    resultSet.getInt("pass"),
                    resultSet.getInt("submit"),
                    resultSet.getString("img"),
                    resultSet.getInt("mode")
            );
            problemList.add(problem);
        }
        return problemList;
    }

    @Override
    public List<Problem> findProblemByPagination(int mode, int type, int start, int end) {
        List<Problem> problemList = new ArrayList<>();
        String sql = "select * from problem where mode=? and type=? limit ?,?";
        Connection connection = DBUtils.getConnection();
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1,mode);
            pst.setInt(2,type);
            pst.setInt(3,start);
            pst.setInt(4,end);
            problemList = pagination(pst);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close();
        }
        return problemList;
    }

    @Override
    public List<Problem> findProblemByPagination(int start, int end) {
        List<Problem> problemList = null;
        String sql = "select * from problem limit ?,?";
        Connection connection = DBUtils.getConnection();
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1,start);
            pst.setInt(2,end);
            problemList = pagination(pst);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return problemList;
    }

    @Override
    public int findProblemNumberWithMode(int mode) {
        String sql = "select count(0) from problem where mode=?";
        Connection connection = DBUtils.getConnection();
        int num = 0;
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setInt(1,mode);
            ResultSet resultSet = pst.executeQuery();

            while (resultSet.next()){
                num = Integer.parseInt(resultSet.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return num;
    }
}
