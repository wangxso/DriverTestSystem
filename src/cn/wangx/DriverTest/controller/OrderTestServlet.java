package cn.wangx.DriverTest.controller;

import cn.wangx.DriverTest.pojo.Problem;
import cn.wangx.DriverTest.service.ProblemService;
import cn.wangx.DriverTest.service.impl.ProblemServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * 顺序练习servlet
 * @author wangx
 *
 */
@WebServlet(name = "OrderTestServlet", urlPatterns = "/getOrderTest")
public class OrderTestServlet extends HttpServlet {
    private ProblemService problemService = new ProblemServiceImpl();
    private static final Logger logger = LoggerFactory.getLogger(OrderTestServlet.class);
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //问题的id
        String pid = (String) request.getAttribute("pid");
        if(pid == null){
             pid = request.getParameter("pid");
        }
        // 用户选择的模式 0为顺序 1为随机 2位专项 3为模拟考试
        String mode = request.getParameter("mode");
        // problem的类型 1为科目一 4为科目四
        String type = request.getParameter("type");
        logger.info("get the request params pid: "+pid+"\tmode: "+mode+"\ttype: "+type);
        Problem problem = problemService.findProblemById(Long.parseLong(pid));
        //拆分选项以:分割的
        String[] chooses = problem.getChooseItem().split(":");
        //获取session
        HttpSession session = request.getSession();
        //将选项存入session中
        session.setAttribute("chooses",chooses);
        //将问题存入session中
        session.setAttribute("problem",problem);
        logger.info("===================problem=======================");
        logger.info(problem.toString());

        // 不是初始进入就新建cookie pass和fail
        if(mode!=null){
            Cookie pass = new Cookie("pass","0");
            response.addCookie(pass);
            Cookie fail = new Cookie("fail","0");
            response.addCookie(fail);
        }
        //跳转页面
        response.sendRedirect("Test.jsp");
    }

    /**
     * 判断是否存在cookie
     * @param name cookie 名称
     * @param request
     * @return true 表示存在 false 表示不存在
     */
    private Boolean isHasCookie(String name,HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie1:cookies){
            if(name.equals(cookie1.getName())){
                return true;
            }
        }
        return false;
    }
}
