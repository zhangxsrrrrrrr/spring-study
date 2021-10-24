package edu.ahau.thinking.in.spring.ioc.source.injection;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author zhangxuna
 * @date 2021-10-16 13:54
 */
public class XmlDenpendencySetterInjectionDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader xmlReader = new XmlBeanDefinitionReader(beanFactory);
        xmlReader.loadBeanDefinitions("classpath:/META-INF/dependency-injection-setter-context.xml");

        UserHolder userHolder = beanFactory.getBean(UserHolder.class);
        System.out.println(userHolder);
    }
}
