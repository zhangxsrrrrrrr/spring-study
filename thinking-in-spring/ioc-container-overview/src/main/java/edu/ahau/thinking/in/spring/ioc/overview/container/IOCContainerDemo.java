package edu.ahau.thinking.in.spring.ioc.overview.container;

import edu.ahau.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * @author zhangxuna
 * @create 2021-10-11 14:05
 * @description TODO
 */
public class IOCContainerDemo {
    public static void main(String[] args) {
        // 创建BeanFactory容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 入参给的是BeanDefinitionRegistry，DefaultListableBeanFactory 实现了BeanDefinitionRegistry接口
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        // XML文件的classpath
        String classpath = "classpath:/META-INF/dependency-injection-context.xml";
        // 加载配置
        int i = reader.loadBeanDefinitions(classpath);
        System.out.println("读取Bean的个数"+i);
        lookupCollectByType(beanFactory);


    }
    private static void lookupCollectByType(BeanFactory context) {
        if (context instanceof ListableBeanFactory) {
            ListableBeanFactory  listableBeanFactory =  (ListableBeanFactory) context;;
            Map<String, User> beansOfType = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("map集合===" +
                    ""+beansOfType);
        }
    }
}
