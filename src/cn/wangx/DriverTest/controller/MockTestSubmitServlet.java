package cn.wangx.DriverTest.controller;

import cn.wangx.DriverTest.pojo.User;
import cn.wangx.DriverTest.service.UserService;
import cn.wangx.DriverTest.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "MockTestSubmitServlet", urlPatterns = "/mockSubmit")
public class MockTestSubmitServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pass = request.getParameter("pass");
        String fail = request.getParameter("fail");
        int pass_num = Integer.parseInt(pass);
        int fail_num = Integer.parseInt(fail);
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        session.setAttribute("pass",pass);
        session.setAttribute("fail",fail);
        session.setAttribute("blank",100-pass_num-fail_num);

        User user = (User) session.getAttribute("user");
        if(user == null){
            out.println("{\"data\":\"fail\"}");
        }else{
            String uid = user.getUid();
            userService.updateUserPassNumberAndFailNumber(uid, pass_num, fail_num);
            out.println("{\"data\":\"success\"}");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
