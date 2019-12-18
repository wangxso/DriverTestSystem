package cn.wangx.DriverTest.service;

import cn.wangx.DriverTest.pojo.UserProblem;

import java.util.List;

public interface UserProblemService {
    /**
     * 添加用户做题记录
     * @param userProblem
     * @return
     */
    int addUserProblemHistory(UserProblem userProblem);

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
