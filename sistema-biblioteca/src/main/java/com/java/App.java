package com.java;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App 
{
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(App.class, args);
         System.out.println(ctx);
    }
}
