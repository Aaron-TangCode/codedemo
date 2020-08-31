package com.hailintang.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.hailintang")
@SpringBootApplication
public class CodeDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodeDemoApplication.class, args);
    }
}
