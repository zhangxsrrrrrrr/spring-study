package edu.ahau.mvc.controller;

import edu.ahau.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhangxuna
 * @date 2021-12-21 13:43
 */
@Controller
public class DemoController {
    @Autowired
    private UserService userService;


    @RequestMapping("/user")
    @ResponseBody
    public String qryUser() {
        System.out.println(userService.qryUsers());
        return "haha";
    }
}
