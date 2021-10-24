package edu.ahau.thinking.in.spring.ioc.source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.PostConstruct;

/**
 * @author zhangxuna
 * @date 2021-10-22 13:11
 */
public class ResolvableDependencyDemo {
    @Autowired
    private String value;

    @PostConstruct
    public void init() {
        System.out.println(value);
    }
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ResolvableDependencyDemo.class);

        // 执行refresh后回调注册
        applicationContext.addBeanFactoryPostProcessor(beanFactory -> {
           beanFactory.registerResolvableDependency(String.class, "Hello,world");
        });

        applicationContext.refresh();
        AutowireCapableBeanFactory beanFactory = applicationContext.getAutowireCapableBeanFactory();

        if (beanFactory instanceof ConfigurableListableBeanFactory) {
            ConfigurableListableBeanFactory listableBeanFactory = ConfigurableListableBeanFactory.class.cast(beanFactory);
            // 注册Resolvable Dependency


        }

    }
}
