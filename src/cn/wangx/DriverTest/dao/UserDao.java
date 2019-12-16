package cn.wangx.DriverTest.dao;

import cn.wangx.DriverTest.pojo.User;
import cn.wangx.DriverTest.pojo.UserProfile;
import cn.wangx.DriverTest.pojo.UserVisited;

import java.util.List;

public interface UserDao {
    /**
     * 从数据库通过id查找用户
     * @param uid 用户id
     * @return 用户信息
     */
    User findUserById(String uid);

    /**
     * 从数据库通过用户名查找用户
     * @param username 用户名
     * @return 用户信息
     */
    User findUserByUsername(String username);

    /**
     * 查找所有的用户信息
     * @return 所有的用户信息
     */
    List<User> findAllUser();

    /**
     * 删除用户通过id
     * @param uid 用户id
     * @return 0为删除失败 1为删除成功
     */
    int deleteUserById(String uid);

    /**
     * 更新用户信息
     * @param user 用户信息
     * @return 0为更新失败 1为更新成功
     */
    int updateUser(User user);

    /**
     * 查找用户数量
     * @return 用户数量
     */
    int findAllUserNumber();

    /**
     * 添加用户登录历史
     * @param userVisited 用户登录历史信息体
     * @return 0为失败 1为成功
     */
    int addUserVisitedHistory(UserVisited userVisited);

    /**
     * 查询用户访问次数(总)
     * @return 用户访问的次数
     */
    int findUserVisitedNumber();

    /**
     * 查找所有访问记录
     * @return 所有访问记录
     */
    List<UserVisited> findAllUserVisited();

    /**
     * 分页查询用户
     * @param start 开始的位置
     * @param end 结束的位置
     * @return 用户列表
     */
    List<User> findUserByPagination(int start, int end);

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
}
