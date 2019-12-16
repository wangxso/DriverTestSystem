package cn.wangx.DriverTest.service.impl;

import cn.wangx.DriverTest.dao.UserDao;
import cn.wangx.DriverTest.dao.impl.UserDaoImpl;
import cn.wangx.DriverTest.pojo.User;
import cn.wangx.DriverTest.pojo.UserProfile;
import cn.wangx.DriverTest.pojo.UserVisited;
import cn.wangx.DriverTest.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public List<User> findAllUser() {
        return null;
    }

    @Override
    public int findAllUserNumber() {
        int allUserNumber = userDao.findAllUserNumber();
        return allUserNumber;
    }

    @Override
    public int addUserVisitedHistory(UserVisited userVisited) {
        return userDao.addUserVisitedHistory(userVisited);
    }

    @Override
    public int findUserVisitedNumber() {
        return userDao.findUserVisitedNumber();
    }

    @Override
    public List<User> findUserByPagination(int start, int end) {
        return userDao.findUserByPagination(start, end);
    }

    @Override
    public List<UserVisited> findAllUserVisited() {
        return userDao.findAllUserVisited();
    }

    @Override
    public int addUserProfile(UserProfile userProfile) {
        return userDao.addUserProfile(userProfile);
    }

    @Override
    public UserProfile findUserProfileByUid(String uid) {
        return userDao.findUserProfileByUid(uid);
    }

    @Override
    public int updateUserProfile(UserProfile userProfile) {
        return updateUserProfile(userProfile);
    }

    @Override
    public int updateUserPassNumberAndFailNumber(String uid, int pass, int fail) {
        UserProfile userProfile;
        userProfile = findUserProfileByUid(uid);
        //数据库中无此人，未提交过题目
        if(userProfile == null){
            userProfile = new UserProfile(uid,"",pass,fail);
            addUserProfile(userProfile);
        }else {
            //提交过题目更新
            userProfile.setPassNumber(userProfile.getPassNumber()+pass);
            userProfile.setFailNumber(userProfile.getFailNumber()+fail);
            updateUserProfile(userProfile);
        }
        return 1;
    }
}
