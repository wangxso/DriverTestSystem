package cn.wangx.DriverTest.controller;

import cn.wangx.DriverTest.pojo.UserProblem;
import cn.wangx.DriverTest.service.UserProblemService;
import cn.wangx.DriverTest.service.impl.UserProblemServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 添加用户做题记录
 */
@WebServlet(name = "AddUserProblemServlet", urlPatterns = "/addUserProblem")
public class AddUserProblemServlet extends HttpServlet {
    Logger logger = LoggerFactory.getLogger(AddUserProblemServlet.class);
    UserProblemService userProblemService = new UserProblemServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uid = request.getParameter("uid");
        String pid = request.getParameter("pid");
        String status = request.getParameter("status");
        String type = request.getParameter("type");
        String mode = request.getParameter("mode");

        UserProblem userProblem = new UserProblem(uid,Integer.parseInt(pid),Integer.parseInt(status),
                Integer.parseInt(type),
                Integer.parseInt(mode));
        logger.info("添加 "+userProblem+"到 user_problem 表中");
        userProblemService.addUserProblemHistory(userProblem);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
