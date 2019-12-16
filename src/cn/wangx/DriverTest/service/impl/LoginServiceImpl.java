package cn.wangx.DriverTest.service.impl;

import cn.wangx.DriverTest.dao.UserDao;
import cn.wangx.DriverTest.dao.impl.UserDaoImpl;
import cn.wangx.DriverTest.pojo.User;
import cn.wangx.DriverTest.service.LoginService;
import cn.wangx.DriverTest.util.MD5Util;
import org.omg.CORBA.PRIVATE_MEMBER;

import java.sql.SQLException;

public class LoginServiceImpl implements LoginService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public User login(User user) {
        User user_find = userDao.findUserByUsername(user.getUsername());
        if(user_find!=null && MD5Util.verify(user.getPassword(), user_find.getPassword())){ // 用户是否存在，并且密码一致
            user_find.setPassword(null); //密码不可被显示
            return user_find; //返回登录的用户信息
        }
        return null; //登录失败
    }
}
