package edu.ahau.thinking.in.spring.ioc.source.injection;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author zhangxuna
 * @date 2021-10-16 15:34
 */
public class AutoWiringByDenpendencySetterInjectionDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader xmlReader = new XmlBeanDefinitionReader(beanFactory);
        xmlReader.loadBeanDefinitions("classpath:/META-INF/autowiring-dependency-injection-setter-context.xml");
        UserHolder userHolder = beanFactory.getBean(UserHolder.class);
        System.out.println(userHolder);
    }
}
