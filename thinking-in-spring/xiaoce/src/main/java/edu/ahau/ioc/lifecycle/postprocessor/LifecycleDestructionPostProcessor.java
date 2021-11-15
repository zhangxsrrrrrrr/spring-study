package edu.ahau.ioc.lifecycle.postprocessor;

import edu.ahau.ioc.lifecycle.bean.Cat;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author zhangxuna
 * @date 2021-11-07 16:53
 */
@Component
public class LifecycleDestructionPostProcessor implements DestructionAwareBeanPostProcessor {
    @Override
    public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
        if (bean instanceof Cat) {
            Cat cat = (Cat) bean;
            System.out.println(cat.getName() + "被放走了 ......");
        }
    }
}
