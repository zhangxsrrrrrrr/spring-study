package edu.ahau.thinking.in.spring.ioc.scope;

import edu.ahau.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.util.Map;

/**
 * @author zhangxuna
 * @date 2021-10-23 21:38
 */
public class BeanScopeDemo {
    @Bean
    @Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public static User singletonUser() {
        User user = new User();
        user.setAge((int) System.nanoTime());
        return user;
    }

    @Bean
    @Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public static User prototypeUser() {
        User user = new User();
        user.setAge((int) System.nanoTime());
        return user;
    }

    @Autowired
    @Qualifier("singletonUser")
    private User singletonUser;
    @Autowired
    @Qualifier("singletonUser")
    private User singletonUser1;

    @Autowired
    @Qualifier("prototypeUser")
    private User prototypeUser;
    @Autowired
    @Qualifier("prototypeUser")
    private User prototypeUser2;

    @Autowired
    private Map<String, User> users;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext beanContext = new AnnotationConfigApplicationContext();
        beanContext.register(BeanScopeDemo.class);
        beanContext.refresh();

        scopeBeanByLookup(beanContext);
        scopeBeansByInjection(beanContext);


        beanContext.close();
    }

    private static void scopeBeansByInjection(AnnotationConfigApplicationContext beanContext) {
        BeanScopeDemo bean = beanContext.getBean(BeanScopeDemo.class);
        System.out.println("===============");
        System.out.println("prototypeUser    "+bean.prototypeUser);
        System.out.println("prototypeUser    "+bean.prototypeUser2);
        System.out.println("singletonUser    "+bean.singletonUser);
        System.out.println("singletonUser    "+bean.singletonUser1);

        System.out.println("map ："+ bean.users);
    }

    private static void scopeBeanByLookup(AnnotationConfigApplicationContext beanContext) {
        for (int i = 0; i < 3; i++) {
            System.out.println("singletonUser =========="+beanContext.getBean("singletonUser", User.class));
        }
        for (int i = 0; i < 3; i++) {
            System.out.println("prototypeUser =========="+beanContext.getBean("prototypeUser", User.class));
        }
    }



}
