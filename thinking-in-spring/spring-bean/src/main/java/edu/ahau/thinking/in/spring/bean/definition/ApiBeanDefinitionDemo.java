package edu.ahau.thinking.in.spring.bean.definition;

import edu.ahau.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * @author zhangxuna
 * @create 2021-10-11 20:41
 * @description 注解 BeanDefinition 实例
 */
public class ApiBeanDefinitionDemo {
    public static void main(String[] args) {
        // 创建BeanFactory容器
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();

        registerUserBeanDefinition(annotationConfigApplicationContext, "zhang");
        registerUserBeanDefinition(annotationConfigApplicationContext);
        annotationConfigApplicationContext.refresh();
        Map<String, User> beansOfType = annotationConfigApplicationContext.getBeansOfType(User.class);

        User zhang = annotationConfigApplicationContext.getBean("zhang", User.class);
        System.out.println(zhang);
        System.out.println(beansOfType);

        annotationConfigApplicationContext.close();
    }

    public static void registerUserBeanDefinition(BeanDefinitionRegistry registry, String beanName){
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder.addPropertyValue("name", "zhangsan");
        beanDefinitionBuilder.addPropertyValue("age", 12);
        if (StringUtils.hasText(beanName)) {
            // 注册 withName
            registry.registerBeanDefinition(beanName, beanDefinitionBuilder.getBeanDefinition());
        } else {
            // 注册 withoutName
            BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinitionBuilder.getBeanDefinition(),registry);
        }

    }
    public static void registerUserBeanDefinition(BeanDefinitionRegistry registry){
        registerUserBeanDefinition(registry, null);
    }
}

