package edu.ahau.thinking.in.spring.ioc.source;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ResourceLoader;

import javax.annotation.PostConstruct;

/**
 * @author zhangxuna
 * @date 2021-10-21 21:22
 */
public class DependencySourceDemo {
    @Autowired
    private BeanFactory beanFactory;
    @Autowired
    ResourceLoader resourceLoader;
    @Autowired
    ApplicationEventPublisher applicationEventPublisher;
    @Autowired
    ApplicationContext applicationContext;

    @PostConstruct
    public void init() {
        System.out.println("beanFactory == applicationContext "+ (beanFactory == applicationContext));
        System.out.println("resourceLoader == applicationContext "+ (resourceLoader == applicationContext));
        System.out.println("beanFactory == applicationContext.getBeanFactory() "+ (beanFactory == applicationContext.getAutowireCapableBeanFactory()));
        System.out.println("applicationEventPublisher == applicationContext "+ (applicationEventPublisher == applicationContext));
    }
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(DependencySourceDemo.class);
        applicationContext.refresh();
        // 依赖查找
        DependencySourceDemo demo = applicationContext.getBean(DependencySourceDemo.class);


        applicationContext.close();
    }
}
