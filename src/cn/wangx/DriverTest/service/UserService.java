package cn.wangx.DriverTest.service;

import cn.wangx.DriverTest.pojo.User;
import cn.wangx.DriverTest.pojo.UserProfile;
import cn.wangx.DriverTest.pojo.UserVisited;

import java.util.List;

public interface UserService {
    /**
     * 查询所有用户信息
     * @return 用户列表
     */
    List<User> findAllUser();

    /**
     * 查询用户数量
     * @return 用户数量
     */
    int findAllUserNumber();

    /**
     * 添加用户登录历史
     * @param userVisited 用户登录信息体
     * @return 0为插入数据库失败 1为成功
     */
    int addUserVisitedHistory(UserVisited userVisited);

    /**
     * 查询用户访问的次数
     * @return 用户访问的次数
     */
    int findUserVisitedNumber();

    /**
     * 分页查询
     * @param start 开始
     * @param end 结束
     * @return 用户信息列表
     */
    List<User> findUserByPagination(int start, int end);

    /**
     * 查找所有访问记录
     * @return 所有访问记录
     */
    List<UserVisited> findAllUserVisited();

    /**
     * 添加用户通过和错误题数
     * @param userProfile 用户信息集合
     * @return 0为失败 1为成功
     */
    int addUserProfile(UserProfile userProfile);

    /**
     * 通过用户id查找用户个人数据
     * @param uid 用户id
     * @return 用户数据
     */
    UserProfile findUserProfileByUid(String uid);

    /**
     * 更新user profile信息
     * @param userProfile 信息
     * @return 0为失败 1为成功
     */
    int updateUserProfile(UserProfile userProfile);

    /**
     * 更新用户过题信息
     * @param uid 用户id
     * @param pass 用户通过
     * @param fail 用户错误
     * @return 1成功 0失败
     */
    int updateUserPassNumberAndFailNumber(String uid,int pass,int fail);
}
