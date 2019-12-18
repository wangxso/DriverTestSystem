package cn.wangx.DriverTest.filter;

import cn.wangx.DriverTest.pojo.User;
import com.sun.deploy.net.HttpRequest;
import com.sun.deploy.net.HttpResponse;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 做题拦截器
 * 只有登陆后才能做题
 */
@WebFilter(filterName = "DoProblemFilter",urlPatterns = {"/getUnitTest","/generateMockTest","/personal.jsp"})
public class DoProblemFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if(user!=null){
            chain.doFilter(req, resp);
            return;
        }else{
            response.sendRedirect("login.jsp");
            return;
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
