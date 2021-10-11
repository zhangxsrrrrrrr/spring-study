package edu.ahau.thinking.in.spring.ioc.overview.container;

import edu.ahau.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Map;

/**
 * @author zhangxuna
 * @create 2021-10-11 14:05
 * @description TODO
 */
public class AnnotationApplicationContextAsIOCContainerDemo {
    public static void main(String[] args) {
        // 创建BeanFactory容器
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();

        //当前类作为配置类
        annotationConfigApplicationContext.register(AnnotationApplicationContextAsIOCContainerDemo.class);
        annotationConfigApplicationContext.refresh();
        lookupCollectByType(annotationConfigApplicationContext); //map集合==={user=User{name='zhangsan', age=1}}
        annotationConfigApplicationContext.close();
    }
    @Bean
    public User user() {
        User user = new User();
        user.setAge(1);
        user.setName("zhangsan");
        return user;
    }

    private static void lookupCollectByType(BeanFactory context) {
        if (context instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) context;
            ;
            Map<String, User> beansOfType = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("map集合===" +
                    "" + beansOfType);
        }
    }
}
