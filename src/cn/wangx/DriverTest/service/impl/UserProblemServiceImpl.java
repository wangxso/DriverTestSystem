package cn.wangx.DriverTest.service.impl;

import cn.wangx.DriverTest.dao.UserProblemDao;
import cn.wangx.DriverTest.dao.impl.UserProblemDaoImpl;
import cn.wangx.DriverTest.pojo.UserProblem;
import cn.wangx.DriverTest.service.UserProblemService;

import java.util.List;

public class UserProblemServiceImpl implements UserProblemService {
    private UserProblemDao userProblemDao = new UserProblemDaoImpl();
    @Override
    public int addUserProblemHistory(UserProblem userProblem) {
        return userProblemDao.addUserProblem(userProblem);
    }

    @Override
    public List<UserProblem> findUserProblemByUid(String uid) {
        return userProblemDao.findUserProblemByUid(uid);
    }

    @Override
    public List<UserProblem> findUserProblemByPid(int pid) {
        return userProblemDao.findUserProblemByPid(pid);
    }
}
