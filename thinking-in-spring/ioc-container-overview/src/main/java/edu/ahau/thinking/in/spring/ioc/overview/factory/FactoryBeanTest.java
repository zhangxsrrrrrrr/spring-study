package edu.ahau.thinking.in.spring.ioc.overview.factory;

import edu.ahau.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zhangxuna
 * @create 2021-10-11 15:40
 * @description TODO
 */
public class FactoryBeanTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");
        System.out.println(context.getBean("userFactoryBean", User.class));
    }
}
