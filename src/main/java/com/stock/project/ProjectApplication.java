package com.stock.project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

// no mysql and mongo
@SpringBootApplication(exclude = {MongoAutoConfiguration.class})
//@SpringBootApplication
@MapperScan(value = "com.stock.project.dao")
public class ProjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProjectApplication.class, args);
    }
}
