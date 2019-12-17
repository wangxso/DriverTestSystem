package test;

import cn.wangx.DriverTest.dao.ExamDao;
import cn.wangx.DriverTest.dao.impl.ExamDaoImpl;
import cn.wangx.DriverTest.pojo.Exam;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ExamDaoTest {
    ExamDao examDao = new ExamDaoImpl();
    @Test
    void testAddExam(){
        Date nowDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Exam exam = new Exam("123", 100, 10, "{\"123\",\"2\",\"4\"}", sdf.format(nowDate));
        examDao.addExam(exam);
    }

    @Test
    void testFindExamByUid(){
        List<Exam> examByUid = examDao.findExamByUid("123");
        examByUid.forEach(System.out::println);
    }
}
