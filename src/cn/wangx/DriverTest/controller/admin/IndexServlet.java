package cn.wangx.DriverTest.controller.admin;

import cn.wangx.DriverTest.service.ProblemService;
import cn.wangx.DriverTest.service.UserService;
import cn.wangx.DriverTest.service.impl.ProblemServiceImpl;
import cn.wangx.DriverTest.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 后台首页servlet
 * @author wangx
 */
@WebServlet(name = "IndexServlet", urlPatterns = "/goToAdmin")
public class IndexServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    Logger logger = LoggerFactory.getLogger(IndexServlet.class);
    ProblemService problemService = new ProblemServiceImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int userNum = userService.findAllUserNumber();
        session.setAttribute("userNum",userNum);
        int pNum = problemService.findProblemNumber();
        session.setAttribute("pNum",pNum);
        int userVisited = userService.findUserVisitedNumber();
        session.setAttribute("userVisited",userVisited);
        logger.info("用户数量: "+userNum+"\t"+"题目数量:"+pNum+"\t"+"用户总计访问："+userVisited+"\t页面跳转");
        response.sendRedirect("admin/admin-index.jsp");
        return;
    }
}
