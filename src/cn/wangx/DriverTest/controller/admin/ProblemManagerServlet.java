package cn.wangx.DriverTest.controller.admin;

import cn.wangx.DriverTest.pojo.Page;
import cn.wangx.DriverTest.pojo.Problem;
import cn.wangx.DriverTest.pojo.User;
import cn.wangx.DriverTest.service.ProblemService;
import cn.wangx.DriverTest.service.impl.ProblemServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProblemManagerServlet",urlPatterns = "/admin/adminProblemManager")
public class ProblemManagerServlet extends HttpServlet {
    private ProblemService problemService = new ProblemServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取当前页数
        String curr = request.getParameter("curr");
        String mode = request.getParameter("mode");
        String type = request.getParameter("type");
        //构建page对象
        Page<User> page = new Page<>();
        //获取题目总数
        int count = problemService.findProblemNumber();
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
        List<Problem> problemList;
        if(type==null && mode == null){
            problemList = problemService.findProblemByPagination(start,end);
        }else{
             problemList = problemService.findProblemByPagination(Integer.valueOf(mode), Integer.valueOf(type),
                    start, end);
        }
        HttpSession session = request.getSession();
        session.setAttribute("problemPage",problemList);
        session.setAttribute("count",count);
        session.setAttribute("curr",curr);
        session.setAttribute("totalPage",page.getTotalPage());
        response.sendRedirect("admin-problemmanager.jsp");
    }
}
