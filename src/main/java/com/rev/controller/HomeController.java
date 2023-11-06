package com.rev.controller;

import com.rev.dao.TodoDao;
import com.rev.model.Todo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class HomeController extends HttpServlet {

    private TodoDao todoDao;
    public HomeController(){
        todoDao=new TodoDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String id = req.getParameter("id");
        if(id != null){
            todoDao.deleteTodo(id);
        }
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        RequestDispatcher dispatcher=req.getRequestDispatcher("home.jsp");
        int userId= Integer.parseInt(req.getSession().getAttribute("userId").toString());

        String item = req.getParameter("item");
        if(item != null && item.trim().length() > 0)
            todoDao.addTodo(item,userId);

        List<Todo> todos = todoDao.getAllValues(userId);
        req.setAttribute("todos",todos);
        dispatcher.forward(req,resp);
    }
}
