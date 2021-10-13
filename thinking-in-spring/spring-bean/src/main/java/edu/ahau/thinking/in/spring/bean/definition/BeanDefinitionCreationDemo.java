package edu.ahau.thinking.in.spring.bean.definition;

import edu.ahau.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.support.GenericApplicationContext;

/**
 * @author zhangxuna
 * @create 2021-10-11 20:41
 * @description TODO
 */
public class BeanDefinitionCreationDemo {
    public static void main(String[] args) {
        // 1. 通过BeanDefinitionBuilder构建
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder.addPropertyValue("age", 14);
        beanDefinitionBuilder.addPropertyValue("name", "xiaomage");

        // 获取BeanDefinition实例
        BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();

        // 2. 通过AbstractBeanDefinition
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(User.class);

        // 通过MutablePropertyValues临时存储properties属性值
        MutablePropertyValues propertyValues = new MutablePropertyValues();
//        propertyValues.addPropertyValue("age", 14);
//        propertyValues.addPropertyValue("name", "xiaomage");
        propertyValues
                .add("age", 14)
                .add("name", "xiaomage");
        // setPropertyValues：设置Bean的属性值
        genericBeanDefinition.setPropertyValues(propertyValues);

    }
}
