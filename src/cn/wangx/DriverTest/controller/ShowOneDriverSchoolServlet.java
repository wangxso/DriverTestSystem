package cn.wangx.DriverTest.controller;

import cn.wangx.DriverTest.pojo.DriverSchool;
import cn.wangx.DriverTest.service.DriverSchoolService;
import cn.wangx.DriverTest.service.impl.DriverSchoolServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 显示单个驾校信息
 */
@WebServlet(name = "ShowOneDriverSchoolServlet", urlPatterns = "/showOneDriverSchool")
public class ShowOneDriverSchoolServlet extends HttpServlet {
    private DriverSchoolService driverSchoolService = new DriverSchoolServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取前台传来的id
        String s = request.getParameter("id");
        // 转换类型
        int id = Integer.parseInt(s);
        // 查找驾校信息
        DriverSchool driverSchool = driverSchoolService.findDriverSchoolById(id);
        // 获取session
        HttpSession session = request.getSession();
        // 加入session
        session.setAttribute("driver_school",driverSchool);
        // 跳转页面
        response.sendRedirect("entery.jsp");
    }
}
