package com.example.businessappdemo.security.proxy;

import com.example.businessappdemo.security.ds.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthenticationServerProxy {
    private final RestTemplate restTemplate;
    @Value("${auth.server.url}")
    private String baseUrl;

    public AuthenticationServerProxy(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public boolean sendOTP(String name,String code){
        String url = baseUrl +"/otp/check";
        var body =new User();
        body.setUsername(name);
        body.setCode(code);
        var request = new HttpEntity<>(body);
        var response = restTemplate.postForEntity(url,request,Void.class);
        return response
                .getStatusCode()
                .equals(HttpStatus.OK);
    }

    public void sendAuth(String username,String password){
        String url = baseUrl + "/user/auth";
        var body = new User();
        body.setUsername(username);
        body.setPassword(password);
        var request = new HttpEntity<>(body);
        restTemplate.postForEntity(url,request,Void.class);
    }
}
