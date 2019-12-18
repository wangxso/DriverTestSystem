package cn.wangx.DriverTest.controller;

import cn.wangx.DriverTest.pojo.*;
import cn.wangx.DriverTest.service.ExamService;
import cn.wangx.DriverTest.service.ProblemService;
import cn.wangx.DriverTest.service.UserProblemService;
import cn.wangx.DriverTest.service.UserService;
import cn.wangx.DriverTest.service.impl.ExamServiceImpl;
import cn.wangx.DriverTest.service.impl.ProblemServiceImpl;
import cn.wangx.DriverTest.service.impl.UserProblemServiceImpl;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "UserProfileServlet",urlPatterns = "/getUserProfile")
public class UserProfileServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    private UserProblemService userProblemService = new UserProblemServiceImpl();
    private ExamService examService = new ExamServiceImpl();
    private ProblemService problemService = new ProblemServiceImpl();
    private Logger logger = LoggerFactory.getLogger(UserProfileServlet.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        //获取用户信息
        User user = (User) session.getAttribute("user");
        //获取用户个人信息
        UserProfile userProfile = userService.findUserProfileByUid(user.getUid());
        // 获取用户做题记录
        List<UserProblem> userProblemList = userProblemService.findUserProblemByUid(user.getUid());
        // 获取用户考试记录
        List<Exam> examList = examService.findExamByUid(user.getUid());
        // 用户错题详细信息
        Map<Long, Problem> problemMap = new HashMap<>();
        int[] mode1 = new int[8];
        int [] mode4 = new int[9];

        //统计错误类型
        if(userProblemList !=null){
            for (UserProblem userProblem:userProblemList){
                if(userProblem.getMode()==1 && userProblem.getStatus()==0){
                    mode1[userProblem.getType()]++;
                }else if (userProblem.getMode()==4 && userProblem.getStatus()==0){
                    mode4[userProblem.getType()]++;
                }
            }
        }

        logger.info(user.getUsername()+" get user profile data");
        String jsonUserProfile = JSON.toJSONString(userProfile);
        String jsonUserProblemList = JSON.toJSONString(userProblemList);
        String jsonExamList = JSON.toJSONString(examList);
        String jsonProblemMap = JSON.toJSONString(problemMap);

        session.setAttribute("userProfile",userProfile);
        session.setAttribute("userProblemList",userProblemList);
        session.setAttribute("examList",examList);
        session.setAttribute("problemMap",problemMap);
        session.setAttribute("mode1",mode1);
        session.setAttribute("mode4",mode4);
        PrintWriter writer = response.getWriter();
        writer.println("{\"userProfile\":"+jsonUserProfile);
        writer.println(",\"userProblemList\":"+jsonUserProblemList);
        writer.println(",\"examList\":"+jsonExamList);
        writer.println(",\"problemList\":"+jsonProblemMap+"}");
        writer.flush();
        writer.close();
    }
}
