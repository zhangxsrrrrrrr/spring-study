package edu.ahau.ioc.basepackage;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.Stream;

/**
 * @author zhangxuna
 * @date 2021-11-03 22:37
 */
public class AnnoApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(BasePackageClassConfiguration.class);
        applicationContext.refresh();
        Stream.of(applicationContext.getBeanDefinitionNames()).forEach(System.out::println);
    }
}
