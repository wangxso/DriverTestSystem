package cn.wangx.DriverTest.service.impl;

import cn.wangx.DriverTest.dao.ProblemDao;
import cn.wangx.DriverTest.dao.impl.ProblemDaoImpl;
import cn.wangx.DriverTest.pojo.Problem;
import cn.wangx.DriverTest.service.ProblemService;

import java.util.List;

public class ProblemServiceImpl implements ProblemService {
    private ProblemDao problemDao = new ProblemDaoImpl();
    @Override
    public Problem findProblemById(Long pid) {
        return problemDao.findProblemById(pid);
    }

    @Override
    public List<Problem> findProblemByIds(Long[] pids) {
        return null;
    }

    @Override
    public List<Problem> findProblemWithTypeAndMode(String type, Integer mode) {
        List<Problem> problemList = problemDao.findProblemWithModeAndType(type, mode);
        return problemList;
    }

    @Override
    public int findProblemNumber() {
        return problemDao.findProblemNumbers();
    }

    @Override
    public List<Problem> findProblemByPagination(int mode, int type, int start, int end) {
        return problemDao.findProblemByPagination(mode, type, start, end);
    }

    @Override
    public List<Problem> findProblemByPagination(int start, int end) {
        return problemDao.findProblemByPagination(start, end);
    }

    @Override
    public int findProblemNumberWithMode(int mode) {
        return problemDao.findProblemNumberWithMode(mode);
    }
}
