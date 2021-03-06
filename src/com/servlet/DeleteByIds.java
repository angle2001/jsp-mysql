package com.servlet;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteByIds")
public class DeleteByIds extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] ids=req.getParameterValues("ck");
        UserDao dao=new UserDaoImpl();
        dao.deleteByIds(ids);
        req.getRequestDispatcher("/findAllServlet").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
