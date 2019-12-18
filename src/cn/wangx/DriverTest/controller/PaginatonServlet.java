package cn.wangx.DriverTest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 前端假分页
 */
@WebServlet(name = "PaginatonServlet",urlPatterns = "/pagination")
public class PaginatonServlet extends HttpServlet {
    Logger logger = LoggerFactory.getLogger(PaginatonServlet.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String curr = request.getParameter("curr");
        HttpSession session = request.getSession();
        logger.info(curr);
        session.setAttribute("begin",curr);
    }
}
