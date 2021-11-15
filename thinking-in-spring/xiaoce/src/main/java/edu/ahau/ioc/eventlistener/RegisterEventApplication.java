package edu.ahau.ioc.eventlistener;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhangxuna
 * @date 2021-11-03 15:19
 */
public class RegisterEventApplication {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
                "edu.ahau.ioc.eventlistener");
        RegisterService registerService = ctx.getBean(RegisterService.class);
        registerService.testApplication("长大四");
    }
}
