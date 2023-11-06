package com.rev.model;

public class Todo {
    private  int id;
    private  int userId;
    private String item;
    private boolean d_flag=false;

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getUserId(){
        return userId;
    }

    public void setUserId(int userId){
        this.userId = userId;
    }

    public String getItem(){
        return item;
    }

    public void setItem(String item){
        this.item = item;
    }

    public boolean isD_flag(){
        return d_flag;
    }

    public void setD_flag(boolean d_flag){
        this.d_flag = d_flag;
    }
}
