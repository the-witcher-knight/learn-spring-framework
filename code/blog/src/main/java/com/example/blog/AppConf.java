package com.example.blog;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConf {
    @Bean("mysqlConnector")
    DatabaseConnector mysqlConfigure(){
        DatabaseConnector mysqlConnector = new MySqlConnector();
        mysqlConnector.setUrl("jdbc:mysql://host1:33060/blog");
        return mysqlConnector;
    }

    @Bean("mongodbConnector")
    DatabaseConnector mongodbConfigure(){
        DatabaseConnector mongodbConnector = new MongoDB();
        mongodbConnector.setUrl("mongodb://mongodb0.example.com:27017/blog");
        return mongodbConnector;
    }
}
