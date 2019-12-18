package cn.wangx.DriverTest.dao;

import cn.wangx.DriverTest.pojo.UserProblem;

import java.util.List;

public interface UserProblemDao {

    /**
     * 添加用户做题信息
     * @param userProblem 用户做题信息
     * @return 0为失败 1为成功
     */
    int addUserProblem(UserProblem userProblem);

    /**
     * 更新用户做题信息
     * @param userProblem 用户做题信息
     * @return 0为失败 1为成功
     */
    int updateUserProblem(UserProblem userProblem);

    /**
     * 查找用户做题记录
     * @param uid 用户id
     * @return 做题状况列表
     */
    List<UserProblem> findUserProblemByUid(String uid);

    /**
     * 查找题目做题状况
     * @param pid 题目id
     * @return 做题状况列表
     */
    List<UserProblem> findUserProblemByPid(int pid);
}
