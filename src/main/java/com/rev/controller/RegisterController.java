package com.rev.controller;

import com.rev.dao.RegisterDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterController extends HttpServlet {
    private RegisterDao registerDao;
    public RegisterController(){
        registerDao=new RegisterDao();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String username = req.getParameter("username");
        String pass=req.getParameter("password");
        String cPass=req.getParameter("c_password");
        if( username.length()>0){
            if(pass.equals(cPass)) {
                registerDao.addUser(username, pass);
                RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
                dispatcher.forward(req, resp);
            }else{
                req.setAttribute("error",true);
                RequestDispatcher dispatcher=req.getRequestDispatcher("register.jsp");
                dispatcher.forward(req,resp);
            }

        }
    }
}
