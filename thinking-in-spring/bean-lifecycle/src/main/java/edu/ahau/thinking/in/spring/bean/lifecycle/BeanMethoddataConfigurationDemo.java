package edu.ahau.thinking.in.spring.bean.lifecycle;

import edu.ahau.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.EncodedResource;

/**
 * @author zhangxuna
 * @date 2021-10-25 8:52
 */
public class BeanMethoddataConfigurationDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        /* Xml配置读取 */
//        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
//        String xmlPath = "";
//        reader.loadBeanDefinitions(xmlPath);
        PropertiesBeanDefinitionReader reader = new PropertiesBeanDefinitionReader(beanFactory);
        String location = "META-INF/user.properties";
        ClassPathResource resource = new ClassPathResource(location);
        EncodedResource encodedResource = new EncodedResource(resource, "UTF-8");
        int i = reader.loadBeanDefinitions(encodedResource);
        System.out.println("已加载数量" + i);

//        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
//        BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanDefinitionNames[0]);
//        System.out.println(beanDefinitionNames);
        System.out.println(beanFactory.getBean( User.class));
    }
}
