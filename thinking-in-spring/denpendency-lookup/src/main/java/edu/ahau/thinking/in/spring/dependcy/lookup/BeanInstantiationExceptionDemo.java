package edu.ahau.thinking.in.spring.dependcy.lookup;

import edu.ahau.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.BeanInstantiationException;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * {@link BeanInstantiationException} 实例
 * @author zhangxuna
 * @date 2021-10-15 14:39
 */
public class BeanInstantiationExceptionDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(CharSequence.class);

        applicationContext.registerBeanDefinition("user", builder.getBeanDefinition());
        applicationContext.refresh();
        applicationContext.getBean("user");


        List<User> users = new ArrayList<>();
        users.add(new User("zhangsan",12));
        users.add(new User("zhangsan1",12));
        users.add(new User("zhangsan2",12));
        users.add(new User("zhangsi",13));
        users.add(new User("zhangsi",13));
        users.add(new User("zhangsi",13));
        users.add(new User("zhangsi",13));
        HashMap<String, User> stringUserHashMap = new HashMap<>();

    }
}
