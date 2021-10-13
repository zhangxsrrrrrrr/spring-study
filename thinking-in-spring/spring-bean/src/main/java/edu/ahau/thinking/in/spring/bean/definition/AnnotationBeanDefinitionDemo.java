package edu.ahau.thinking.in.spring.bean.definition;

import edu.ahau.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

/**
 * @author zhangxuna
 * @create 2021-10-11 20:41
 * @description 注解 BeanDefinition 实例
 */
public class AnnotationBeanDefinitionDemo {
    public static void main(String[] args) {
        // 创建BeanFactory容器
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        // 注册一个类(配置类   instead of   xml)
        annotationConfigApplicationContext.register(Config.class);

        // 1.通过@Bean方式定义
        // 2.通过@Component方式
        // 3.通过@Import
        annotationConfigApplicationContext.close();
    }

    @Component
    public static class Config {
        @Bean
        public User user(){
            User user = new User();
            user.setAge(12);
            return user;
        }
    }
}

