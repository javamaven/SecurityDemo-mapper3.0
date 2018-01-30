package com.security.demo.SecurityDemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by ${chenhaijun} on 2018/1/24.
 */
@Controller
@Slf4j
public class IndexController {
    @RequestMapping("/")
    public String index(){
        return "/admin/home";
    }

    @RequestMapping(value="/login")
    public String login(HttpServletRequest request){
        String host = request.getRemoteHost();
        System.out.println(getIp(request));
        log.info("hahdhshdf");
        return "/login";
    }

    public String getIp(HttpServletRequest req){
        String ipAddress = req.getHeader("x-forwarded-for");
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = req.getHeader("Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress =req.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = req.getRemoteAddr();
            if (ipAddress != null &&(ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1"))) {
                // 根据网卡取本机配置的IP
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                    ipAddress = inet.getHostAddress();
                } catch (UnknownHostException e) {
                    System.out.println("get IpAddress error");
                }
            }
        }
        // 对于通过多个代理的情况，第一个IP为客户端真实IP
        if (ipAddress != null && ipAddress.length() > 15) {
            if (ipAddress.indexOf(",") > 0) {
                ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
            }
        }
        return ipAddress == null ? "unknown" : ipAddress;
    }
}
