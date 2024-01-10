package com.example.businessappdemo.security.provider;


import com.example.businessappdemo.security.UserNamePasswordAuthentication;
import com.example.businessappdemo.security.proxy.AuthenticationServerProxy;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class UsernamePasswordAuthenticationProvider implements
        AuthenticationProvider {
    private final AuthenticationServerProxy proxy;
    public UsernamePasswordAuthenticationProvider(AuthenticationServerProxy proxy) {
        this.proxy = proxy;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = String.valueOf(authentication.getCredentials());
        proxy.sendAuth(username,password);
        return new UsernamePasswordAuthenticationToken(username,password);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UserNamePasswordAuthentication.class
                .isAssignableFrom(authentication);
    }
}
