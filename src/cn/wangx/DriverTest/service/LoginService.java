package cn.wangx.DriverTest.service;

import cn.wangx.DriverTest.pojo.User;

public interface LoginService {

    /**
     * 用户登录
     *
     * @param user
     * @return 返回用户信息 返回null为登陆失败
     */
    User login(User user);
}
