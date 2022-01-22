package com.cody.web;

import com.cody.pojo.User;
import com.cody.service.UserService;
import com.cody.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;

/**
 * 类功能描述
 *
 * @Author hyx
 * @Date 2022/1/13
 */
@RestController
public class ForeRESTController {

    @Autowired
    UserService userService;

    @PostMapping("/forelogin")
    public Object login(@RequestBody User userParam, HttpSession session) {
        String name =  userParam.getName();
        name = HtmlUtils.htmlEscape(name);
        User user = userService.getByName(name);
        if(user==null){
            String message ="账号不存在";
            return Result.fail(message);
        }else if(user.getPassword().equals(userParam.getPassword())){
            session.setAttribute("user", user);
            return Result.success();
        }else{
            String message ="账号密码错误";
            return Result.fail(message);
        }
    }
}
