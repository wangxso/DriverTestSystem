package cn.wangx.DriverTest.service;

import cn.wangx.DriverTest.pojo.Exam;

import java.util.List;

public interface ExamService {
    /**
     * 查找已经完成的考试
     * @param uid 用户id
     * @return 用户已经完成的考试
     */
    List<Exam> findExamByUid(String uid);

    /**
     * 考试结束，添加考试记录
     * @param exam 考试记录信息
     * @return 0为失败 1为成功
     */
    int addExam(Exam exam);

    /**
     * 添加用户考试信息
     * @param uid 用户id
     * @param pass 用户正确题目数量
     * @param fail 用户错误题目数量
     * @param pidList 考试题目列表
     * @return 0为失败 1为成功
     */
    int addExamInfo(String uid,int pass, int fail,String pidList);
}
