package com.hneu.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.hneu.api.dao")
@EntityScan(basePackages = "com.hneu.api.model")
public class FacultyAndStudentsApplication {

    public static void main(String[] args) {
        SpringApplication.run(FacultyAndStudentsApplication.class, args);
    }

}
