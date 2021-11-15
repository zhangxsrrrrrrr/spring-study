package edu.ahau.thinking.in.spring.bean.lifecycle;

import edu.ahau.thinking.in.spring.ioc.overview.domain.SuperUser;
import edu.ahau.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.util.ObjectUtils;

/**
 *
 * bean  实例化
 * 1. InstantiationAwareBeanPostProcessor
 *
 * @author zhangxuna
 * @date 2021-10-27 8:48
 */
public class BeanInstantiationLifecycleDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);

        reader.loadBeanDefinitions("classpath:\\META-INF/dependency-looKup-context.xml");
        System.out.println(beanFactory.getBean("superUser"));  //SuperUser{address='null'}User{name='null', age=0, beanName='null', workCities=null, cityList=null} 被拦截
        System.out.println(beanFactory.getBean("user"));  //
        System.out.println(beanFactory.getBean("objectFactory"));  //

    }

    static class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
        @Override
        public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
            // 拦截superUser
//            if (ObjectUtils.nullSafeEquals("superUser", beanName) && SuperUser.class.equals(beanClass)) {
//                return new SuperUser();
//            }
            return null;
        }

        // 配置一下元信息
        @Override
        public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
            if (ObjectUtils.nullSafeEquals("user", beanName) && User.class.equals(bean.getClass())) {
                // “user” 对象不允许赋值 ，xml中配置的所有元信息都不会执行
                User user = (User) bean;
                user.setName("haha");
                return false;
            }
                return true;
        }

        // 上面的user  和  superUser都不会执行这个方法
        @Override
        public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
            if (beanName.equals("superUser") && bean.getClass().equals(SuperUser.class)){
                MutablePropertyValues propertyValues = new MutablePropertyValues();
                propertyValues.addPropertyValue("address", "shenz");
                return propertyValues;
            }
            return null;
        }
    }
}
