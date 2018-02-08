package com.security.demo.SecurityDemo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by ${chenhaijun} on 2018/1/30.
 * 实现底层UserDetailsService
 */
@Service("securityUserDetailsService")
@Slf4j
public class SecurityUserDetailsService implements UserDetailsService{

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //根据用户名返回密码 校验方法
        log.info("---------从数据库中获取密码----------");
        if(username.indexOf("user")!=-1){
            log.info("--------------密码---------"+123456);
            return new User(username,"123456", AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));
        }else{
         throw new  UsernameNotFoundException("用户名错误");
        }
    }

    /**
     * 加密密码
     */
    private String encryptPassword(String password){
        return new BCryptPasswordEncoder().encode(password);
    }
}
