package edu.ahau.ioc.enable;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.Stream;

/**
 * @author zhangxuna
 * @date 2021-11-03 15:57
 */
public class TavernApplication {

    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(TavernConfiguration.class);
        ctx.refresh();
        Stream.of(ctx.getBeanDefinitionNames()).forEach(System.out::println);
    }
}
