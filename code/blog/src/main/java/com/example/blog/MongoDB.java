package com.example.blog;

public class MongoDB extends DatabaseConnector{
    @Override
    public void connect(){
        System.out.println("Đã kết nối tới MongoDB: " + getUrl());
    }
}
