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

@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String age=req.getParameter("age");
        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String gender = req.getParameter("gender");
        String birthday = req.getParameter("birthday");

        User user=new User();
        user.setName(name);
        user.setUsername(username);
        user.setPassword(password);
        user.setAge((Integer.parseInt(age)));
        user.setGender(gender);
        user.setBirthday(birthday);


        UserDao userDao=new UserDaoImpl();
        int i=userDao.addUser(user);

        if (i>0){
            req.getRequestDispatcher("/findAllServlet").forward(req,resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
