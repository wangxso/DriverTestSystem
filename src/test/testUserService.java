package test;

import cn.wangx.DriverTest.pojo.User;
import cn.wangx.DriverTest.service.LoginService;
import cn.wangx.DriverTest.service.impl.LoginServiceImpl;
import org.junit.jupiter.api.Test;

public class testUserService {
    @Test
    void testLogin(){
        User user = new User();
        user.setUsername("admin");
        user.setPassword("123456");
        LoginService loginService = new LoginServiceImpl();
        User login = loginService.login(user);
        System.out.println(login);
    }
}
