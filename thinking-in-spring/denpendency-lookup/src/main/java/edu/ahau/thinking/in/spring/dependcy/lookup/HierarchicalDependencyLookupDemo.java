package edu.ahau.thinking.in.spring.dependcy.lookup;

import edu.ahau.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ResolvableType;

import java.util.Arrays;

/**
 * 层次行依赖查找(双亲委派机制)
 *
 * @author zhangxuna
 * @create 2021-10-13 14:34
 */
public class HierarchicalDependencyLookupDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ObjectProviderDemo.class);
        // 获取HierarchicalBeanFactory  <-  ConfigurableBeanFactory  <-  ConfigurableListableBeanFactory
        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
        // 设置ParentBeanFactory
        beanFactory.setParentBeanFactory(createParentBeanFactory());
        displayLocalBean(beanFactory, "user");
        displayLocalBean(createParentBeanFactory(), "user");
        System.out.println("=========================");
        displayContainsBean(beanFactory, "user");


        getBeansByBeanFactoryUtils(beanFactory, "user");
        applicationContext.refresh();


    }

    public static void displayContainsBean(HierarchicalBeanFactory beanFactory, String beanName) {
        System.out.printf("当前 BeanFactory[%s] 是否包含bean[name : %s]   包含了:[%s] \n", beanFactory, beanName, containsBean(beanFactory, beanName));
    }

    private static boolean containsBean(HierarchicalBeanFactory beanFactory, String beanName) {
        BeanFactory parentBeanFactory = beanFactory.getParentBeanFactory();
        if (parentBeanFactory instanceof HierarchicalBeanFactory) {
            HierarchicalBeanFactory cast = (HierarchicalBeanFactory) parentBeanFactory;
            if (containsBean(cast, beanName)) {
                return true;
            }
        }
        return beanFactory.containsLocalBean(beanName);
    }

    public static void displayLocalBean(HierarchicalBeanFactory beanFactory, String beanName) {
        System.out.printf("当前 BeanFactory[%s] 是否包含bean[name : %s]   包含了:[%s] \n", beanFactory, beanName, beanFactory.containsLocalBean(beanName));
    }

    private static HierarchicalBeanFactory createParentBeanFactory() {
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
        int i = reader.loadBeanDefinitions("classpath:/META-INF/dependency-looKup-context.xml");
        return defaultListableBeanFactory;
    }

    // 使用BeanFactoryUtils,双亲委派机制
    private static void getBeansByBeanFactoryUtils(ListableBeanFactory beanFactory, String beanName) {
        String[] strings = BeanFactoryUtils.beanNamesForTypeIncludingAncestors(beanFactory, User.class);

        System.out.println(Arrays.asList(strings).contains(beanName));
    }
}
