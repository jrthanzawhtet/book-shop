package com.example.businessappdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    //curl  -H "username:john" -H "password:12345" http://localhost:9090/login
    //curl -v -H "username:john" -H "code:2783" http://localhost:9090/login
    //curl -H "Authorization:eyJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6ImpvaG4ifQ.aFu7q3-Kl4Qs1vU_tGLI82I89vXzlbTnv023VhCXKhA" http://localhost:9090/hello
    @GetMapping("/hello")
    public String hello(){
        return "Hello!";
    }
}
