package com.rev.controller;

import com.rev.dao.UserDao;
import com.rev.db.DbConnection;
import com.rev.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthController extends HttpServlet {
    UserDao userDao;
    public AuthController(){
        userDao=new UserDao();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        String username=req.getParameter("username");
        String password=req.getParameter("password");

        User loggedInUser=userDao.loginUser(username,password);

        if(loggedInUser != null){
            HttpSession session=req.getSession();
            session.setAttribute("userId",loggedInUser.getId());
            RequestDispatcher dispatcher=req.getRequestDispatcher("home.jsp");
            dispatcher.forward(req,resp);
        }else {
            req.setAttribute("error",true);
            RequestDispatcher dispatcher=req.getRequestDispatcher("login");
            dispatcher.forward(req,resp);
        }

    }
}
