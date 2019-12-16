package cn.wangx.DriverTest.service;

import cn.wangx.DriverTest.pojo.Problem;

import java.util.List;

public interface ProblemService {

    /**
     * 查询题目数量
     * @return 题目的数量
     */
    int findProblemNumber();


    /**
     * 通过id找到题目
     * @param pid 题目的id
     * @return
     */
    Problem findProblemById(Long pid);

    /**
     * 通过一组id找到题目
     * @param pids
     * @return
     */
    List<Problem> findProblemByIds(Long[] pids);

    /**
     * 通过type和mode查找题目
     * @param type 问题的类型，代表第几章
     * @param mode 问题的模式，代表科目一和科目四
     * @return
     */
    List<Problem> findProblemWithTypeAndMode(String type,Integer mode);

    /**
     * 分页查询题目
     * @param mode 1代表科目一 4代表科目四
     * @param type 表示章节
     * @param start 开始标记
     * @param end 结束标记
     * @return 题目列表
     */
    List<Problem> findProblemByPagination(int mode,int type,int start,int end);

    /**
     * 分页查询题目
     * @param start 开始标记
     * @param end 结束标记
     * @return 题目列表
     */
    List<Problem> findProblemByPagination(int start,int end);

    /**
     * 查找科目x的个数
     * @param mode 1代表科目一 4代表科目四
     * @return 数量
     */
    int findProblemNumberWithMode(int mode);

}
