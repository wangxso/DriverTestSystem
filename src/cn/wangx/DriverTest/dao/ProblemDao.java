package cn.wangx.DriverTest.dao;

import cn.wangx.DriverTest.pojo.Problem;

import java.util.List;

/**
 * 问题持久层
 *
 */
public interface ProblemDao {
    /**
     * 通过id查询题目详细信息
     * @param pid 题目的id
     * @return 题目的详细信息
     */
    Problem findProblemById(Long pid);

    /**
     * 通过一组id查询题目详细信息
     * @param pids 一组id
     * @return 查询到的题目信息
     */
    List<Problem> findProblemByIds(Long[] pids);

    /**
     * 查找题目通过题目的类型和模式
     * @param type
     * @param mode
     * @return
     */
    List<Problem> findProblemWithModeAndType(String type, Integer mode);

    /**
     * 添加 or 更新problem数据
     * @param problem 新加或更新后的problem对象
     * @return 0为添加失败 1为成功
     */
    int updateProblem(Problem problem);

    /**
     * 删除id对应的题目
     * @param pid 题目的id
     * @return 0为失败 1为成功
     */
    int deleteProblemById(Long pid);

    /**
     * 删除一组题目
     * @param pids 题目的id组成的数组
     * @return 0为失败 1为成功
     */
    int deleteProblemByIds(Long[] pids);

    /**
     * 查询题目的数量
     * @return 题目的数量
     */
    int findProblemNumbers();

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
