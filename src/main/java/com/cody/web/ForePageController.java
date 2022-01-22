package com.cody.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 类功能描述
 *
 * @Author hyx
 * @Date 2022/1/13
 */
@Controller
public class ForePageController {

    @GetMapping(value="/login")
    public String login(){
        return "fore/login";
    }

    @GetMapping(value="/home")
    public String home(){
        return "fore/home";
    }

    @GetMapping(value="/")
    public String homePage(){
        return "fore/home";
    }

    @GetMapping(value="/addOrder")
    public String addOrder(){
        return "fore/addOrder";
    }

    @GetMapping(value="/editOrder")
    public String editOrder(){
        return "fore/editOrder";
    }
}
