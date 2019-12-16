package test;

import cn.wangx.DriverTest.dao.ProblemDao;
import cn.wangx.DriverTest.dao.impl.ProblemDaoImpl;
import cn.wangx.DriverTest.pojo.Problem;
import cn.wangx.DriverTest.util.GenProblemIdUtils;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ProblemDaoTest {
    ProblemDao problemDao = new ProblemDaoImpl();
    @Test
    void testfindProblemById(){
        Problem problem = problemDao.findProblemById(1L);
        System.out.println(problem);

    }

    @Test
    void testFindProblemWithTypeAndMode(){
        List<Problem> problemList = problemDao.findProblemWithModeAndType("1", 1);
        problemList.forEach(System.out::println);
    }

    @Test
    void testPagination(){
        List<Problem> problemList = problemDao.findProblemByPagination(1,10);
        System.out.println(problemList.size());
    }

    @Test
    void testGenProblemId(){
        List<Integer> integers = GenProblemIdUtils.genProblemId(10, 100,80);
        integers.forEach(System.out::println);
    }

    @Test
    void testFindModeProblem(){
        System.out.println(problemDao.findProblemNumberWithMode(4));
    }
}
