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

@WebServlet("/findByConditionServlet")
public class FindByConditionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String age=req.getParameter("age");
        String name = req.getParameter("name");
        String gender = req.getParameter("gender");
        UserDao dao=new UserDaoImpl();
        List<User> list=dao.findByCondition(name,gender,age);
        if (list!=null){
            req.setAttribute("list",list);
            req.getRequestDispatcher("jsp/list.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
