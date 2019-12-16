package cn.wangx.DriverTest.controller;

import cn.wangx.DriverTest.pojo.UserVisited;
import cn.wangx.DriverTest.service.UserService;
import cn.wangx.DriverTest.service.impl.UserServiceImpl;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * 用户浏览记录servlet
 * @author wangx
 */
@WebServlet(name = "UserVisitedHistoryServlet", urlPatterns = "/getUserVisitedHistory")
public class UserVisitedHistoryServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    Logger logger = LoggerFactory.getLogger(UserVisitedHistoryServlet.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 查出所有的用户浏览记录
        List<UserVisited> allUserVisited = userService.findAllUserVisited();
        //转换为json字符串
        String json = JSON.toJSONString(allUserVisited);
        logger.info(json);
        // 输出到网页
        PrintWriter out = response.getWriter();
        out.println(json);
        out.flush();
        out.close();
    }
}
