package edu.ahau.thinking.in.spring.bean.definition;

import edu.ahau.thinking.in.spring.bean.factory.DefaultUserFactory;
import edu.ahau.thinking.in.spring.bean.factory.UserFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhangxuna
 * @create 2021-10-13 9:37
 */
public class SingletonBeanRegistrationDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 注册外部单例对象
        DefaultUserFactory userFactory = new DefaultUserFactory();
        //   ConfigurableListableBeanFactory接口很重要
        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
        beanFactory.registerSingleton("userFactory",userFactory);

        // 启动应用上下文
        applicationContext.refresh();
        UserFactory userFactory1 = applicationContext.getBean("userFactory", UserFactory.class);
        System.out.println(userFactory == userFactory1);
        applicationContext.close();

    }
}
