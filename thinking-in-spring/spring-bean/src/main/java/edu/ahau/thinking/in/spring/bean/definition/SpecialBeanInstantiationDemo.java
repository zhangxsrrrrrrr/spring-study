package edu.ahau.thinking.in.spring.bean.definition;

import edu.ahau.thinking.in.spring.bean.factory.DefaultUserFactory;
import edu.ahau.thinking.in.spring.bean.factory.UserFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ServiceLoader;

/**
 * @author zhangxuna
 * @create 2021-10-12 12:43
 * @description TODO
 */
public class SpecialBeanInstantiationDemo {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/special-bean-instantiation-context.xml");
        // 1.ServiceLoaderFactoryBean创建Bean,可以显示多个bean
//        displayServiceLoader(serviceLoaderFactoryBean);


        // 通过ApplicationContext 获取 AutowireCapableBeanFactory
        AutowireCapableBeanFactory beanFactory = applicationContext.getAutowireCapableBeanFactory();
        ServiceLoader<UserFactory> serviceLoaderFactoryBean = beanFactory.getBean("serviceLoaderFactoryBean", ServiceLoader.class);
        // 不能使用接口，与ServiceLoaderFactoryBean不一样
        UserFactory bean = beanFactory.createBean(DefaultUserFactory.class);
        displayServiceLoader(serviceLoaderFactoryBean);
//        System.out.println(bean.createUser());


    }

    // java中的反转控制
    public static void demoServiceLoader() {
        ServiceLoader<UserFactory> load = ServiceLoader.load(UserFactory.class, Thread.currentThread().getContextClassLoader());
        displayServiceLoader(load);
    }

    public static void displayServiceLoader(ServiceLoader<UserFactory> serviceLoader) {
        Iterator<UserFactory> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            UserFactory next = iterator.next();
            System.out.println(next.createUser());
        }
    }
}
