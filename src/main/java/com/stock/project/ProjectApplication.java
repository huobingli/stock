package com.stock.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.web.bind.annotation.RestController;

// no mysql and mongo
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,MongoAutoConfiguration.class})
//@SpringBootApplication
@RestController

public class ProjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProjectApplication.class, args);
    }
}
