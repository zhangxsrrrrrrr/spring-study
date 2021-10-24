package edu.ahau.thinking.in.spring.dependcy.lookup;

import edu.ahau.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * beanFactory是单一查找的核心
 *
 * 查找方式最好是先根据名称再根据类型去查找
 *
 * 非延迟加载的Bean 进行延迟查找
 *
 * ObjectProvider 继承  BeanFactory
 * @author zhangxuna
 * @create 2021-10-13 12:51
 */
public class ObjectProviderDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ObjectProviderDemo.class);
        applicationContext.refresh();
//        User bean = applicationContext.getBean(User.class);
//        System.out.println(bean);

//        lookupByObjectProvider(applicationContext);


        lookupByObjectProviderSuplier(applicationContext);
        lookupByObjectProviderStreamOps(applicationContext);
    }



    public static void lookupByObjectProvider(AnnotationConfigApplicationContext context) {
        ObjectProvider<User> beanProvider = context.getBeanProvider(User.class);
        System.out.println(beanProvider.getObject());
    }


    /**
     * 延迟查找，如果不存在bean，则给自定的对象，类似于Optional
     */
    private static void lookupByObjectProviderSuplier(AnnotationConfigApplicationContext context) {
        ObjectProvider<User> beanProvider = context.getBeanProvider(User.class);
        User user = beanProvider.getIfAvailable(User::createUser);
        System.out.println(user);
    }

    private static void lookupByObjectProviderStreamOps(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<String> beanProvider = applicationContext.getBeanProvider(String.class);
        beanProvider.stream().forEach(System.out::println);
    }


    @Bean
    public String hello() {
        return "hello";
    }
    @Bean
    public String message() {
        return "message";
    }


}
