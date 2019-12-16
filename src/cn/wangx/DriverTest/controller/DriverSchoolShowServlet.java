package cn.wangx.DriverTest.controller;

import cn.wangx.DriverTest.pojo.DriverSchool;
import cn.wangx.DriverTest.pojo.Page;
import cn.wangx.DriverTest.pojo.Problem;
import cn.wangx.DriverTest.pojo.User;
import cn.wangx.DriverTest.service.DriverSchoolService;
import cn.wangx.DriverTest.service.impl.DriverSchoolServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DriverSchoolShowServlet", urlPatterns = "/showDriverSchool")
public class DriverSchoolShowServlet extends HttpServlet {
    private DriverSchoolService driverSchoolService = new DriverSchoolServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取当前页数
        String curr = request.getParameter("curr");
        //构建page对象
        Page<User> page = new Page<>();
        //获取题目总数
        int count = driverSchoolService.findDriverSchoolNumber();
        //设置题目总数
        page.setRows(count);
        //一页十条数据
        page.setPageSize(10);
        if(curr != null){
            page.setPageNo(Integer.valueOf(curr));
        }
        //每一页第一个元素
        int start = (page.getPageNo() - 1)* page.getPageSize();
        //每一页最后一个元素
        int end =  page.getPageSize() + start;
        //向上取整
        int totalPage = (int) Math.ceil((double) count / Double.valueOf(page.getPageSize()));
        page.setTotalPage(totalPage);
        //分页查询
        List<DriverSchool> driverSchoolPagination = driverSchoolService.findDriverSchoolPagination(start, end);

        HttpSession session = request.getSession();
        session.setAttribute("driverSchoolPage",driverSchoolPagination);
        session.setAttribute("count",count);
        session.setAttribute("curr",curr);
        session.setAttribute("totalPage",page.getTotalPage());
        response.sendRedirect("findDriverSchool.jsp");
    }
}
