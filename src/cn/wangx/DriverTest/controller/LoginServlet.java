package cn.wangx.DriverTest.controller;

import cn.wangx.DriverTest.pojo.User;
import cn.wangx.DriverTest.pojo.UserVisited;
import cn.wangx.DriverTest.service.LoginService;
import cn.wangx.DriverTest.service.UserService;
import cn.wangx.DriverTest.service.impl.LoginServiceImpl;
import cn.wangx.DriverTest.service.impl.UserServiceImpl;
import cn.wangx.DriverTest.util.HttpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 登录servlet
 * @author wangx
 */
@WebServlet(urlPatterns = "/login")
public class LoginServlet extends javax.servlet.http.HttpServlet {
    private LoginService loginService = new LoginServiceImpl();
    private UserService userService = new UserServiceImpl();
    private static final Logger logger = LoggerFactory.getLogger(LoginServlet.class);
    /**
     * 登录
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws IOException
     */
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        try {
            String username =   request.getParameter("username");
            String password = request.getParameter("password");
            String remember = request.getParameter("remember");
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            //登录ip，通过HttpUtils获得
            String loginIp = HttpUtils.getIPAddress(request);
            //登录的user agent
            String browser = request.getHeader("User-Agent");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date nowDate = new Date();
            String date = sdf.format(nowDate);
            UserVisited userVisited = new UserVisited(username,loginIp,browser,date);
            logger.info(userVisited.toString());
            userService.addUserVisitedHistory(userVisited);
            // 不为null表示成功 null表示失败
            if((user = loginService.login(user)) != null){
                logger.info(username+" --->登陆成功");
                //将用户信息保存到session中
                HttpSession session = request.getSession();
                session.setAttribute("user",user);
                //如果点击remember me，在cookie中保存username
                if(remember != null){
                    Cookie cookie = new Cookie("user",user.getUsername());
                }
                response.sendRedirect("index.jsp");
                return;
            }else{
                //失败用户名或密码不能存在
                HttpSession session = request.getSession();
                session.setAttribute("error","1");
                response.sendRedirect("login.jsp");
                return;
            }
        }catch (IndexOutOfBoundsException e){
            //下标越界异常
            HttpSession session = request.getSession();
            session.setAttribute("error","1");
            response.sendRedirect("login.jsp");
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
    }
}
