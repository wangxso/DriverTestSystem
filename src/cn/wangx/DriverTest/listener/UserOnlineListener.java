package cn.wangx.DriverTest.listener;

import cn.wangx.DriverTest.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.util.ArrayList;
import java.util.List;

@WebListener()
public class UserOnlineListener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {
    Logger logger = LoggerFactory.getLogger(UserOnlineListener.class);
    ServletContext application = null;
    // Public constructor is required by servlet spec
    public UserOnlineListener() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
      //用来保存 ，已登录的用户
      List<User> userList = new ArrayList<>();
      //取得application对象
      application = sce.getServletContext();
      //将集合设置到application中去
      application.setAttribute("allUser",userList);
      logger.info("用户在线监听器初始化！");
    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
      logger.info("服务器关闭，用户在线监听器销毁！");
    }

    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */

    }

    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // -------------------------------------------------------

    public void attributeAdded(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute 
         is added to a session.
      */
      List<User> userList = (List<User>) application.getAttribute("allUser");
      User user = (User) sbe.getValue();
      //用户未登录
      if (userList.indexOf(user) == -1){
          logger.info(user.toString()+" 登陆了");
          userList.add(user);
      }
      application.setAttribute("allUser",userList);
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is removed from a session.
      */
        List<User> userList = (List<User>) application.getAttribute("allUser");
        User user = (User) sbe.getValue();
        //用户未登录
        if (userList.indexOf(user) == 1){
            logger.info(user.toString()+" 退出了");
            userList.remove(user);
        }
        application.setAttribute("allUser",userList);
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attibute
         is replaced in a session.
      */
    }
}
