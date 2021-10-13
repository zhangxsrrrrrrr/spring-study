package edu.ahau.thinking.in.spring.bean.definition;

import edu.ahau.thinking.in.spring.bean.factory.DefaultUserFactory;
import edu.ahau.thinking.in.spring.bean.factory.UserFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zhangxuna
 * @create 2021-10-12 15:13
 */
public class BeanInitializationDemo {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册配置类
        applicationContext.register(BeanInitializationDemo.class);
        // 启动Spring应用上下文
        applicationContext.refresh();
        System.out.println("Spring应用上下文已启动");
        // 依赖查找
        applicationContext.getBean(UserFactory.class);
        // 关闭Spring应用上下文
        applicationContext.close();
    }

    @Bean(initMethod = "initUserFactory", destroyMethod = "destroyFactory")
    public UserFactory userFactory() {
        return new DefaultUserFactory();
    }
}

