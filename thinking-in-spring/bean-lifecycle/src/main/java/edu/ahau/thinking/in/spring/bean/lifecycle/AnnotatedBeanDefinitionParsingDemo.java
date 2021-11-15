package edu.ahau.thinking.in.spring.bean.lifecycle;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;

/**
 * @author zhangxuna
 * @date 2021-10-25 21:37
 */
public class AnnotatedBeanDefinitionParsingDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory registry = new DefaultListableBeanFactory();

        // 基于java注解的 BeanDefinitionReader
        AnnotatedBeanDefinitionReader reader = new AnnotatedBeanDefinitionReader(registry);
        // 对BeanNameGenerator重新实现，并且重新注入
        MyBeanNameGenerator myBeanNameGenerator = new MyBeanNameGenerator();
        reader.setBeanNameGenerator(myBeanNameGenerator);
        int beanNumberNumsBefore = registry.getBeanDefinitionCount();
        // 注册当前类（非component）
        reader.register(AnnotatedBeanDefinitionParsingDemo.class);
        int beanNumberNumsAfter = registry.getBeanDefinitionCount();
        System.out.println("已加载BeanDefinition数量： "+(beanNumberNumsAfter - beanNumberNumsBefore));
        // 普通的class作为Component注册到SpringIoC容器后，通常Bean名称为小驼峰
        // AnnotationBeanNameGenerator对BeanName的构造


        System.out.println(registry.getBean("haha"));

    }
}
