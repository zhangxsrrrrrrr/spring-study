package edu.ahau.aop.aspect.service;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author zhangxuna
 * @date 2021-11-15 14:32
 */
@ComponentScan("edu.ahau.aop.aspect")
@EnableAspectJAutoProxy(exposeProxy=true)
public class AnnotationAspectApplication {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext()) {
          applicationContext.register(AnnotationAspectApplication.class);
          applicationContext.refresh();
            FinanceService bean = applicationContext.getBean(FinanceService.class);
            bean.addMoney(123);
            System.out.println(bean.subtractMoney(123.12));
        }
    }
}
