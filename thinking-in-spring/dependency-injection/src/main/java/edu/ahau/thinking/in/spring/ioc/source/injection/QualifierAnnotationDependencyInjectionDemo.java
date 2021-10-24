package edu.ahau.thinking.in.spring.ioc.source.injection;

import edu.ahau.thinking.in.spring.ioc.source.annotation.InjectedUser;
import edu.ahau.thinking.in.spring.ioc.source.annotation.UserGroup;
import edu.ahau.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * {@link Qualifier} 注解依赖注入
 * @author zhangxuna
 * @date 2021-10-18 21:00
 */
public class QualifierAnnotationDependencyInjectionDemo {
    @Autowired
    @Qualifier("user")
    private User user;

    @Autowired
    @Qualifier("superUser")
    private User nameUser;

    /*
    为什么user1 user2没有注入进去？
        user1，user2有@Qualifier注解，分类了
     */
    @Autowired
    private Collection<User> allUsers;

    @Autowired
    @Qualifier
    private Collection<User> allUsers1;

    @Autowired
    @UserGroup
    private Collection<User> qualifiedUsers;

    @InjectedUser
    private User injectUser;

    @Bean
    @Qualifier
    public User user1(){
        User user = new User();
        user.setName("qualifierBean1");
        return user;
    }

    @Bean
    @Qualifier
    public User user2() {
        User user = new User();
        user.setName("qualifierBean2");
        return user;
    }

    @Bean
    @UserGroup
    public User user3() {
        User user = new User();
        user.setName("UserGroup3");
        return user;
    }
    @Bean
    @UserGroup
    public User user4(){
        User user = new User();
        user.setName("UserGroup4");
        return user;
    }
//    @Bean(name = AUTOWIRED_ANNOTATION_PROCESSOR_BEAN_NAME)
//    public static AutowiredAnnotationBeanPostProcessor beanPostProcessor() {
//        AutowiredAnnotationBeanPostProcessor beanPostProcessor = new AutowiredAnnotationBeanPostProcessor();
//        // 替换原有的注解，使用新注解
//        beanPostProcessor.setAutowiredAnnotationType(InjectedUser.class);
//        Set<Class<? extends Annotation>> autowiredAnnotationTypes =
//                new LinkedHashSet<>(Arrays.asList(Autowired.class, InjectedUser.class));
//        beanPostProcessor.setAutowiredAnnotationTypes(autowiredAnnotationTypes);
//        return beanPostProcessor;
//    }
    @Bean
    public static AutowiredAnnotationBeanPostProcessor beanPostProcessor() {
        AutowiredAnnotationBeanPostProcessor beanPostProcessor = new AutowiredAnnotationBeanPostProcessor();
        // 替换原有的注解，使用新注解
        beanPostProcessor.setAutowiredAnnotationType(InjectedUser.class);
        Set<Class<? extends Annotation>> autowiredAnnotationTypes =
                new LinkedHashSet<>(Arrays.asList( InjectedUser.class));
        beanPostProcessor.setAutowiredAnnotationTypes(autowiredAnnotationTypes);
        return beanPostProcessor;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(QualifierAnnotationDependencyInjectionDemo.class);

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(applicationContext);
        reader.loadBeanDefinitions("META-INF/dependency-looKup-context.xml");
        applicationContext.refresh();
        QualifierAnnotationDependencyInjectionDemo demo = applicationContext.getBean(QualifierAnnotationDependencyInjectionDemo.class);
        System.out.println(demo.user);
        System.out.println(demo.nameUser);
        System.out.println("=============");
        System.out.println(demo.allUsers);
        System.out.println(demo.qualifiedUsers);
        System.out.println(demo.allUsers1);
        System.out.println(demo.injectUser);
    }
}
