package cn.wangx.DriverTest.controller;

import cn.wangx.DriverTest.pojo.Exam;
import cn.wangx.DriverTest.pojo.User;
import cn.wangx.DriverTest.pojo.UserProfile;
import cn.wangx.DriverTest.service.ExamService;
import cn.wangx.DriverTest.service.UserService;
import cn.wangx.DriverTest.service.impl.ExamServiceImpl;
import cn.wangx.DriverTest.service.impl.UserServiceImpl;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

@WebServlet(name = "MockTestSubmitServlet", urlPatterns = "/mockSubmit")
public class MockTestSubmitServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    private ExamService examService = new ExamServiceImpl();
    Logger logger = LoggerFactory.getLogger(MockTestSubmitServlet.class);
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
            logger.info("uid: "+uid+"用户考试结束，记录用户考试信息");
            List<Integer> problem_id_list = (List<Integer>) session.getAttribute("problem_id_list");
            String pid_list = JSON.toJSONString(problem_id_list);
            logger.info(pid_list);
            //更新考试历史记录
            examService.addExamInfo(uid, pass_num, fail_num,pid_list);
            //更新用户总做题数量
            userService.updateUserPassNumberAndFailNumber(uid,pass_num,fail_num);
            out.println("{\"data\":\"success\"}");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
