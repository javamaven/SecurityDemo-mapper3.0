package com.security.demo.SecurityDemo.config;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${chenhaijun} on 2018/1/24.
 */
@Component
public class UserAuthenticationProvider implements AuthenticationProvider {

    static final List<GrantedAuthority> AUTHORITIES = new ArrayList<GrantedAuthority>();

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) authentication;
        Object details = auth.getDetails();
        String username = String.valueOf(auth.getPrincipal());
        String password = String.valueOf(auth.getCredentials());
        String remoteAddress ="";
        if (details instanceof WebAuthenticationDetails) {
            WebAuthenticationDetails webDetails = (WebAuthenticationDetails) details;
            remoteAddress = webDetails.getRemoteAddress();
        }

        if(username.indexOf("user")<0){
            throw new BadCredentialsException("用户名或者密码错误");
        }
        if(!"123456".equals(password)){
            throw new BadCredentialsException("密码错误");
        }
        AUTHORITIES.add(new SimpleGrantedAuthority("ROLE_USER"));
        return new UsernamePasswordAuthenticationToken(auth.getName(),
                null, AUTHORITIES);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
