package cn.wangx.DriverTest.service.impl;

import cn.wangx.DriverTest.dao.ExamDao;
import cn.wangx.DriverTest.dao.impl.ExamDaoImpl;
import cn.wangx.DriverTest.pojo.Exam;
import cn.wangx.DriverTest.service.ExamService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ExamServiceImpl implements ExamService {
    private ExamDao examDao = new ExamDaoImpl();
    @Override
    public List<Exam> findExamByUid(String uid) {
        return examDao.findExamByUid(uid);
    }

    @Override
    public int addExam(Exam exam) {
        return examDao.addExam(exam);
    }

    @Override
    public int addExamInfo(String uid, int pass, int fail, String pidList) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date nowDate = new Date();
        Exam exam = new Exam(uid, pass, fail,pidList,sdf.format(nowDate));
        return addExam(exam);
    }
}
