package edu.ahau.thinking.in.spring.bean.lifecycle;

import edu.ahau.thinking.in.spring.ioc.overview.domain.SuperUser;
import edu.ahau.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 *
 * BeanDefinition   合并实例
 * @author zhangxuna
 * @date 2021-10-26 21:33
 */
public class MergedBeanDefinitionDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);

        reader.loadBeanDefinitions("classpath:\\META-INF/dependency-looKup-context.xml");

        User user = beanFactory.getBean("user", User.class);
        System.out.println(user);
        SuperUser superUser = beanFactory.getBean("superUser", SuperUser.class);
        System.out.println(superUser);
    }
}
