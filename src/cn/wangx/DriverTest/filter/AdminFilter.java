package cn.wangx.DriverTest.filter;

import cn.wangx.DriverTest.dao.UserDao;
import cn.wangx.DriverTest.dao.impl.UserDaoImpl;
import cn.wangx.DriverTest.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebFilter(filterName = "AdminFilter", urlPatterns = "/admin/*")
public class AdminFilter implements Filter {
    private UserDao userDao = new UserDaoImpl();
    Logger logger = LoggerFactory.getLogger(AdminFilter.class);
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpServletRequest request = (HttpServletRequest) req;
        User user = new User();
        try {
            HttpSession session = request.getSession();
            user = (User) session.getAttribute("user");

            if("admin".equals(user.getRole())){
                List<User> userL = userDao.findAllUser();
                session.setAttribute("userList",userL);
                logger.info(user.getUsername() + ",访问了后台");
                chain.doFilter(req, resp);
            }else{
                logger.info(user.getUsername() + ",无权限访问了后台");
                response.sendRedirect("/admin/admin-404.jsp");
            }
        }catch (NullPointerException e){
            e.printStackTrace();
            PrintWriter writer = response.getWriter();
            logger.info(user.getUsername() + ",无权限访问了后台");
            writer.println("<h1>500</h1>");
            writer.println("<h3>Permission Denied</h3>");
        }

    }

    public void init(FilterConfig config) throws ServletException {
        logger.info("用户拦截器初始化");
    }

}
