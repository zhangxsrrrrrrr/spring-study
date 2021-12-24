package edu.ahau.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhangxuna
 * @date 2021-12-20 17:44
 */
@Controller
public class DemoController {
    @RequestMapping("/demo")
    public String demo() {
        return "demo";
    }
}
