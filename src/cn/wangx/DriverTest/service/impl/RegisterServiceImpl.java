package cn.wangx.DriverTest.service.impl;

import cn.wangx.DriverTest.dao.UserDao;
import cn.wangx.DriverTest.dao.impl.UserDaoImpl;
import cn.wangx.DriverTest.pojo.User;
import cn.wangx.DriverTest.service.RegisterService;
import cn.wangx.DriverTest.util.UuidMaker;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RegisterServiceImpl implements RegisterService {
    UserDao userDao = new UserDaoImpl();
    @Override
    public Boolean register(User user) {
        // 用户分为普通用户(normal) 和 管理员(admin)
        user.setRole("normal");
        user.setUid(UuidMaker.makeUUid());
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowDate = sdf.format(date);
        user.setCreateDate(nowDate);
        userDao.updateUser(user);
        return true;
    }
}
