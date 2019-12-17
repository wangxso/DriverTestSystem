package cn.wangx.DriverTest.controller;

import cn.wangx.DriverTest.dao.ProblemDao;
import cn.wangx.DriverTest.pojo.Problem;
import cn.wangx.DriverTest.service.ExamService;
import cn.wangx.DriverTest.service.ProblemService;
import cn.wangx.DriverTest.service.impl.ExamServiceImpl;
import cn.wangx.DriverTest.service.impl.ProblemServiceImpl;
import cn.wangx.DriverTest.util.GenProblemIdUtils;
import cn.wangx.DriverTest.util.RedisUtils;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 生成模拟考试相关servlet
 * @author wangx
 *
 */
@WebServlet(name = "GenerateMockTest",urlPatterns = "/generateMockTest")
public class GenerateMockTestServlet extends HttpServlet {
    private ProblemService problemService = new ProblemServiceImpl();
    private final Logger logger = LoggerFactory.getLogger(GenerateMockTestServlet.class);
    private Jedis jedis = RedisUtils.getJedis();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String curr = req.getParameter("curr");
        String mode = req.getParameter("mode");
        logger.info("get curr equals "+ curr);
        //当前考试的id
        Long pid = null;
        //从题库随机生成一个序列长度为100
        List<Integer> problemIdList = new ArrayList<>();
        // 1. 找出总长度
        int mode1 = problemService.findProblemNumberWithMode(1);
        int mode4 = problemService.findProblemNumberWithMode(4);
        // 首次进入考试，生成题目序列
        if(curr == null || "".equals(curr)){
            // 2. 生成序列
            if("1".equals(mode)){
                problemIdList = GenProblemIdUtils.genProblemId(0,mode1,100);
            }else if("4".equals(mode)){
                problemIdList = GenProblemIdUtils.genProblemId(mode1+1,mode4+mode1,50);
            }
            HttpSession session = req.getSession();
            session.setAttribute("problem_id_list", problemIdList);
            pid = Long.valueOf(problemIdList.get(0));
            session.setAttribute("curr",0);
        }else{
            HttpSession session = req.getSession();
            problemIdList = (List<Integer>) session.getAttribute("problem_id_list");
            int index = Integer.parseInt(curr);
            pid = Long.valueOf(problemIdList.get(index));
            session.setAttribute("curr",curr);
        }
        // 3.将序列添加到session中
        HttpSession session = req.getSession();
        //已经在redis中了
        Problem problemById = null;
        String problemJson = jedis.hget("problem",""+pid);
        logger.info(problemJson);
        if (problemJson!=null && !"".equals(problemJson)){
            problemById = JSON.parseObject(problemJson,Problem.class);
            logger.info("get from redis's problem is "+problemById);
        }else{
            //不在redis中就查数据库存入redis
            problemById = problemService.findProblemById(pid);
            String json = JSON.toJSONString(problemById);
            jedis.hset("problem",""+pid,json);
            logger.info("add to redis pid="+pid+" content="+json);
        }

        String title = problemById.getContent();
        //拆分选项以:分割的
        String[] chooses = problemById.getChooseItem().split(":");
        session.setAttribute("problem_by_id", problemById);
        //拆分选择项
        session.setAttribute("chooses",chooses);
        session.setAttribute("mode",mode);
        resp.sendRedirect("mouniTest.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
