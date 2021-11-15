package edu.ahau.thinking.in.spring.bean.strategy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zhangxuna
 * @date 2021-10-28 9:25
 */
public class Test {
    @Value("123qqq")
    private String name;

    public static void main(String[] args) {
        ConfigurableApplicationContext beanFactory = new ClassPathXmlApplicationContext("classpath:META-INF\\findBean.xml");
        DefaultListableBeanFactory defaultListable = new DefaultListableBeanFactory();
        beanFactory.refresh();
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(defaultListable);
        applicationContext.register(Test.class);
        beanFactory.setParent(applicationContext);
        applicationContext.refresh();
        StrategyUseService bean = beanFactory.getBean(StrategyUseService.class);
//        System.out.println(bean);
//        bean.resolveFile(FileTypeResolveEnum.matchByValue(1), "123");
        System.out.println(beanFactory.getBean(Test.class).name);

    }




}
