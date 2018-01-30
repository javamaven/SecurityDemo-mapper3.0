package com.security.demo.SecurityDemo.controller;

import com.security.demo.SecurityDemo.model.City;
import com.security.demo.SecurityDemo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ${chenhaijun} on 2018/1/23.
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    CityService cityService;

    @RequestMapping("/say")
    @ResponseBody
    public String saveHello(HttpServletRequest request){
        Object usertamp = request.getRemoteUser();
        System.out.println("---");
        return "helloworld111";
    }

    @RequestMapping("/")
    public String index(){
        return "/admin/home";
    }

    @RequestMapping("/home")
    public String home(){
        return "/admin/home";
    }

    @RequestMapping("/hello")
    public String hello(Model model){
        City city = new City();
        city.setName("fgdfg");
        city.setId(11);
        cityService.selectCount(11);
        return "/admin/hello";
    }

}
