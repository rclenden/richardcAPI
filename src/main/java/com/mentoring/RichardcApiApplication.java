package com.mentoring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.mentoring.model") 
public class RichardcApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RichardcApiApplication.class, args);
    }

}