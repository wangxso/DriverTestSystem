package cn.wangx.DriverTest.dao;

import cn.wangx.DriverTest.pojo.Exam;

import java.util.List;

public interface ExamDao {

    /**
     * 查找已经完成的考试
     * @param uid 用户id
     * @return 用户已经完成的考试
     */
    List<Exam> findExamByUid(String uid);

    /**
     * 考试结束，添加考试记录
     * @param exam 考试记录信息
     * @return
     */
    int addExam(Exam exam);






}
