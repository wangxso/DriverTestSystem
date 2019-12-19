package cn.wangx.DriverTest.controller.admin;

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
import java.util.ArrayList;
import java.util.List;

/**
 * Create by wangx On 2019/12/19
 **/
@WebServlet(name = "DeleteUserByIdServlet",urlPatterns = "/admin/deleteUserById")
public class DeleteUserByIdServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    private Logger logger = LoggerFactory.getLogger(DeleteUserByIdServlet.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uids = request.getParameter("uids");
        logger.info("uids:  "+uids);
        List<String> idList = JSON.parseArray(uids, String.class);
        int res = userService.deleteUsersById(idList);
        String json = "";
        if(res == 1){
            json += "{\"result\":\"success\"}";
        }else{
            json += "{\"result\":\"error\"}";
        }
        PrintWriter writer = response.getWriter();
        writer.println(json);
        writer.flush();
        writer.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
