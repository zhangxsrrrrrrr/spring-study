package edu.ahau.thinking.in.spring.bean.lifecycle;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;

/**
 * @author zhangxuna
 * @date 2021-10-25 22:14
 */
public class MyBeanNameGenerator implements BeanNameGenerator {
    @Override
    public String generateBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {
        return "haha";
    }
}
