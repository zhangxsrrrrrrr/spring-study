package edu.ahau.thinking.in.spring.ioc.source;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author zhangxuna
 * @date 2021-10-23 17:05
 */
@Configuration
@PropertySource(value = "classpath:META-INF/default.properties",encoding = "UTF-8")
public class ExternalConfigurationDemo {
    @Value(value = "${user.page}")
    private  String name;
    @Value(value = "${user.id}")
    private  Integer age;
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ExternalConfigurationDemo.class);

        applicationContext.refresh();
        ExternalConfigurationDemo bean = applicationContext.getBean(ExternalConfigurationDemo.class);
        System.out.println(bean.name);
        System.out.println(bean.age);
    }

}
