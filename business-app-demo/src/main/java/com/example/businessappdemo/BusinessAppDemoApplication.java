package com.example.businessappdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication(exclude = {UserDetailsServiceAutoConfiguration.class})
public class BusinessAppDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BusinessAppDemoApplication.class, args);
    }

}
