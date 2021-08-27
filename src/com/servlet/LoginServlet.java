package com.servlet;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.pojo.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if ("".equals(username) || "".equals(password)) {
            request.setAttribute("msg", "确定用户名或密码为空");
            request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
        }
        UserDao dao = new UserDaoImpl();
        User user = dao.login(username, password);

        if (user != null) {
            //核心
            // 4。合法用户则保存用户信息 session，返回主页
//            session.setAttribute("user", user);
            request.getRequestDispatcher("/findAllServlet").forward(request, response);
        } else {
            request.setAttribute("msg", "确定用户名或密码错误");
            request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
        }
    }
}

