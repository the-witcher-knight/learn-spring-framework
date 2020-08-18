package com.example.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BlogApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(BlogApplication.class, args);

		DatabaseConnector mysql = context.getBean(MySqlConnector.class);
		mysql.connect();

		DatabaseConnector mongodb = context.getBean(MongoDB.class);
		mongodb.connect();
	}


}
