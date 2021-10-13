package edu.ahau.thinking.in.spring.bean.definition;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhangxuna
 * @create 2021-10-13 8:49
 */
public class BeanGarbageCollectionDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext beanFactory = new AnnotationConfigApplicationContext();

        beanFactory.register(BeanInitializationDemo.class);

        beanFactory.refresh();

        beanFactory.close();

        System.gc();

    }
}
