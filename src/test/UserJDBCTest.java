package test;

import cn.wangx.DriverTest.dao.UserDao;
import cn.wangx.DriverTest.dao.impl.UserDaoImpl;
import cn.wangx.DriverTest.pojo.User;
import cn.wangx.DriverTest.pojo.UserProfile;
import cn.wangx.DriverTest.util.DBUtils;
import cn.wangx.DriverTest.util.MD5Util;
import cn.wangx.DriverTest.util.UuidMaker;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserJDBCTest {
    private UserDao userDao = new UserDaoImpl();

    @Test
    public void test() throws SQLException, ClassNotFoundException {
        List<Object[]> select = DBUtils.select("select * from user", null);
        assert select != null;
        for(Object[] ol:select){
            System.out.println(ol[0]);
            System.out.println(ol[1]);
        }
    }

    @Test
    public void testUserDao() throws SQLException {
        UserDao userDao = new UserDaoImpl();
        User user = userDao.findUserById("1");
        System.out.println(user);
    }

    @Test
    void testFindUserByUsername() throws SQLException {
        UserDao userDao = new UserDaoImpl();
        User user = userDao.findUserByUsername("admin");
        System.out.println(user);
    }

    @Test
    void testAddUser() throws SQLException{
        UserDao userDao = new UserDaoImpl();
        User user = new User(UuidMaker.makeUUid(),"admin", MD5Util.generate("123456"),"normal");
        userDao.updateUser(user);
    }

    @Test
    void testFindUserNumbers(){
        UserDao userDao = new UserDaoImpl();
        int allUserNumber = userDao.findAllUserNumber();
        System.out.println(allUserNumber);
    }

    @Test
    void testPagination(){
        List<User> userByPagination = userDao.findUserByPagination(1, 10);
        System.out.println(userByPagination.size());
    }

    @Test
    void testFindUserProfileByUid(){
        UserProfile userProfileByUid = userDao.findUserProfileByUid("540ba66bd6144b23af");
        System.out.println(userProfileByUid);
    }

    @Test
    void testAddUserProfile(){
        UserProfile userProfile = new UserProfile("123","杨健铭",0,200);
        int i = userDao.addUserProfile(userProfile);
        System.out.println(i);
    }

    @Test
    void testUpdateUserProfile(){
        UserProfile userProfile = new UserProfile("123","lishizheng",1,222);
        userDao.updateUserProfile(userProfile);
    }


}
