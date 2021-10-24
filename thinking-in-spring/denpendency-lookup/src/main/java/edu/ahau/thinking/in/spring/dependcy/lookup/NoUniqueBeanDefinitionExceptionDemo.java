package edu.ahau.thinking.in.spring.dependcy.lookup;

import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author zhangxuna
 * @date 2021-10-15 14:19
 */
public class NoUniqueBeanDefinitionExceptionDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(NoUniqueBeanDefinitionExceptionDemo.class);
        applicationContext.refresh();

        try {
            applicationContext.getBean(String.class);
        } catch (NoUniqueBeanDefinitionException ex) {
            System.out.println(ex.getNumberOfBeansFound());
            System.out.println(ex.getBeanType());
            System.out.println(ex.getBeanNamesFound());
        }
        applicationContext.close();
    }
    @Bean
    public String name() {
        return "asdasd";
    }
    @Bean
    public String age() {
        return "12";
    }
}
