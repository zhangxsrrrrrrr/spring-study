package edu.ahau.ioc.lifecycle.postprocessor;

import edu.ahau.ioc.lifecycle.bean.Person;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * bean的后置处理器的回调, BeanDefinition阶段前后处理
 *
 * @author zhangxuna
 * @date 2021-11-07 16:46
 */
@Component
public class LifecycleNameReadPostProcessor implements BeanPostProcessor {


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Person) {
            Person person = (Person) bean;
            System.out.println("LifecycleNameReadPostProcessor ------> " + person.getName());
        }
        return bean;
    }
}
