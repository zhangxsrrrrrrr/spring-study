package edu.ahau.ioc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhangxuna
 * @date 2021-11-03 14:54
 */
public class QuickstartListenerApplication {

    public static void main(String[] args) throws Exception {
        System.out.println("准备初始化IOC容器。。。");
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
                "edu.ahau");
        System.out.println("IOC容器初始化完成。。。");
        ctx.close();
        System.out.println("IOC容器关闭。。。");
    }
}
