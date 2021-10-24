package edu.ahau.thinking.in.spring.dependcy.lookup;

import edu.ahau.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

/**
 * 类型安全，依赖查找示例
 *
 * 使用延迟加载更推荐使用ObjectProvider
 *
 * DefaultListableBeanFactory，单一，集合，层次性BeanFactory的实现    唯一的内建Bean
 * @author zhangxuna
 * @create 2021-10-14 11:15
 */
public class TypeSaftyDependencyLookUpDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 配置类
        applicationContext.register(TypeSaftyDependencyLookUpDemo.class);

        applicationContext.refresh();
        /**
         * 都会报错（NoSuchBeanDefinitionException）
         */
        displayBeanFactoryGetBean(applicationContext);
        displayObjectFactoryGetObject(applicationContext);

        /**
         * 不会报错（NoSuchBeanDefinitionException）
         */
        displayListableBeanFacotryBean(applicationContext);
        displayObjectFactoryGetIfAvailableObject(applicationContext);
        applicationContext.close();
    }

    private static void displayListableBeanFacotryBean(AnnotationConfigApplicationContext applicationContext) {
        Map<String, User> beansOfType = applicationContext.getBeansOfType(User.class);
        printBeanException("displayListableBeanFacotryBean", () -> System.out.println(beansOfType));
    }

    private static void displayObjectFactoryGetIfAvailableObject(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<User> userObjectProvider = applicationContext.getBeanProvider(User.class);
        printBeanException("displayObjectFactoryGetObject", userObjectProvider::getIfAvailable);
    }

    private static void displayObjectFactoryGetObject(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<User> userObjectProvider = applicationContext.getBeanProvider(User.class);
        printBeanException("displayObjectFactoryGetObject", userObjectProvider::getObject);
    }

    public static void displayBeanFactoryGetBean(BeanFactory beanFactory) {
        printBeanException("displayBeanFactoryGetBean", ()->{
            System.out.println(beanFactory.getBean(User.class));
        });
    }

    private static void printBeanException(String source, Runnable runnable) {
        try {
            System.err.println("=====================");
            System.err.println("Source from ："+source);
            runnable.run();
        } catch (BeansException ex) {
            ex.printStackTrace();
        }
    }
//    @Bean(name = "user")
//    public User getUserBean() {
//        return User.createUser();
//    }
//
//    @Bean(name = "superUser")
//    public User getSuperUserBean() {
//        User superUser = new SuperUser();
//        superUser.setName("super");
//        return superUser;
//    }
}
