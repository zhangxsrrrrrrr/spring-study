package edu.ahau.thinking.in.spring.ioc.overview.factory;

import edu.ahau.thinking.in.spring.ioc.overview.factory.config.BeanConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhangxuna
 * @create 2021-10-11 15:40
 * @description TODO
 */
public class FactoryBeanTest {
    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");
//        System.out.println(context.getBean("&toyFactoryBean"));
//        System.out.println(toyFactoryBean.name);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        System.out.println(context.getBean("&toyFactoryBean"));
    }
}
