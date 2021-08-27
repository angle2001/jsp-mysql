package com.servlet;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findAllServlet")
public class FindAllServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao userDao=new UserDaoImpl();
        List<User> list=userDao.findAll();
        req.setAttribute("list",list);
//        所有信息转发到list.jsp中进行展示
        req.getRequestDispatcher("jsp/list.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
