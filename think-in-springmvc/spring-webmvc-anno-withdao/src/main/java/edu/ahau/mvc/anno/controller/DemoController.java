package edu.ahau.mvc.anno.controller;

import edu.ahau.mvc.anno.entity.User;
import edu.ahau.mvc.anno.service.UserService;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhangxuna
 * @date 2021-12-21 15:12
 */
@Controller
public class DemoController {
    @Autowired
    private UserService userService;

    @RequestMapping("/user")
    @ResponseBody
    public String user() {
        System.out.println(userService.qryUsers());
        System.out.println("xixixi");
        return "hah123";
    }

    @RequestMapping("/asd")
    public String asd() {
        return ((DemoController) AopContext.currentProxy()).user();
    }

    @PostMapping("/save")
    @ExceptionHandler
    public String save(@RequestBody User user) {
        int i = 1/0;
        System.out.println(user);
        return "hah";
    }
}
