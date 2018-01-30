package com.security.demo.SecurityDemo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ${chenhaijun} on 2018/1/25.
 */
@RestController
public class ProductController {

    @RequestMapping("/product/{id}")
    public String getProduct(@PathVariable Integer id){
        return "productId="+id;
    }

    @RequestMapping("/order/{id}")
    public String getOrder(@PathVariable Integer id){
        return "orderId="+id;
    }

}
