package edu.ahau.thinking.in.spring.ioc.source.injection;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * 基于Aware（Aware接口回调依赖注入）
 * @author zhangxuna
 * @date 2021-10-16 13:54
 */
public class AwareInterfaceDenpendencyInjectionDemo implements BeanFactoryAware, ApplicationContextAware {
    private static BeanFactory  awareBeanFactory;
    private static AnnotationConfigApplicationContext annotationConfigApplicationContext1;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(AwareInterfaceDenpendencyInjectionDemo.class);
        annotationConfigApplicationContext.refresh();
        String bean = annotationConfigApplicationContext.getBean(String.class);
        System.out.println("ann+ +"+bean);
        getBeanH();

        System.out.println(awareBeanFactory == annotationConfigApplicationContext.getBeanFactory());
        System.out.println(annotationConfigApplicationContext1 == annotationConfigApplicationContext);
        annotationConfigApplicationContext.close();
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        awareBeanFactory = beanFactory;
    }
    private static void getBeanH() {
        String bean = awareBeanFactory.getBean(String.class);
        System.out.println("aware+"+bean);
    }
    @Bean
    private String name() {
        return "hha";
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        annotationConfigApplicationContext1 = (AnnotationConfigApplicationContext) applicationContext;
    }
}
