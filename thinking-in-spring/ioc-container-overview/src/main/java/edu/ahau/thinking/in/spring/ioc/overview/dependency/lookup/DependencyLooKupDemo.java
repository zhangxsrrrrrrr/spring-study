package edu.ahau.thinking.in.spring.ioc.overview.dependency.lookup;

import edu.ahau.thinking.in.spring.ioc.overview.annotation.Super;
import edu.ahau.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.net.ConnectException;
import java.util.Map;

/**
 * @author zhangxuna
 * @create 2021-10-10 16:19
 * @description 依赖查找示例
 *
 *
 * 通过名称来查找
 *      实时查找
 *      延迟查找
 *
 * 通过类型来查找
 *      单个bean
 *      集合bean
 *
 *  通过注解查找对象
 */
public class DependencyLooKupDemo {
    public static void main(String[] args) {
        // 配置XML配置文件
        // 启动Spring的应用上下文
        BeanFactory context = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-looKup-context.xml");

        lookupInrealTime(context);

        lookupInLazyTime(context);

        lookupByType(context);
        lookupCollectByType(context);

        lookupByAnnotationType(context);
    }

    private static void lookupByAnnotationType(BeanFactory context) {
        if (context instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) context;
            Map<String, Object> beans = listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println(beans);
        }
    }

    private static void lookupCollectByType(BeanFactory context) {
        if (context instanceof ListableBeanFactory) {
            ListableBeanFactory  listableBeanFactory =  (ListableBeanFactory) context;;
            Map<String, User> beansOfType = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("map集合===" +
                    ""+beansOfType);
        }
    }

    private static void lookupByType(BeanFactory context) {
        User user = context.getBean(User.class);

        System.out.println("实时加载==="+user);
    }

    private static void lookupInLazyTime(BeanFactory context) {
        ObjectFactory<User> user = (ObjectFactory<User>) context.getBean("objectFactory");
        System.out.println("延迟加载===" + user.getObject());
    }

    private static void lookupInrealTime(BeanFactory beanFactory){
        User user = (User) beanFactory.getBean("user");
        System.out.println("实时加载==="+user);
    }
}
