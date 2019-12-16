package cn.wangx.DriverTest.controller;

import cn.wangx.DriverTest.dao.UserDao;
import cn.wangx.DriverTest.dao.impl.UserDaoImpl;
import cn.wangx.DriverTest.pojo.User;
import cn.wangx.DriverTest.service.RegisterService;
import cn.wangx.DriverTest.service.impl.RegisterServiceImpl;
import cn.wangx.DriverTest.util.MD5Util;
import cn.wangx.DriverTest.util.UuidMaker;
import com.ndktools.javamd5.Mademd5;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

@WebServlet(name = "RegisterServlet",urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    private RegisterService registerService = new RegisterServiceImpl();

    /**
     * 用户注册
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String rePass = request.getParameter("rePass");
            if(password.equals(rePass)){
                User user = new User();
                user.setUsername(username);
                // 用户密码进行MD5加密存储
                user.setPassword(MD5Util.generate(password));
                //用户注册
                registerService.register(user);
                //成功注册跳转登陆页面
                response.sendRedirect("login.jsp");
                return;
            }
            response.sendRedirect("register.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
