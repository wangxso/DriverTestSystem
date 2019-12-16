package cn.wangx.DriverTest.controller;

import cn.wangx.DriverTest.pojo.Problem;
import cn.wangx.DriverTest.service.ProblemService;
import cn.wangx.DriverTest.service.impl.ProblemServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Random;

/**
 * 章节测试servlet
 * @author wangx
 */
@WebServlet(name = "UnitTestServlet", urlPatterns = "/getUnitTest")
public class UnitTestServlet extends HttpServlet {
    ProblemService problemService = new ProblemServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取题目类别
        String type = request.getParameter("type");
        // 测试的方法 有 随机 random 和 非随机 null
        String method = request.getParameter("method");
        // 模式 科目一为1 科目四为4
        Integer mode = Integer.valueOf(request.getParameter("mode"));
        // 查找所有的问题
        List<Problem> problemList = problemService.findProblemWithTypeAndMode(type, mode);
        // 找到 初始的下标
        Integer startIndex = Math.toIntExact(problemList.get(0).getPid());
         //随机出题
         if("random".equals(method)){
             startIndex = startIndex + new Random().nextInt(100);
         }
         request.setAttribute("pid",startIndex.toString());
         //跳转到另一个servlet
         request.getRequestDispatcher("getOrderTest").forward(request, response);
    }
}
