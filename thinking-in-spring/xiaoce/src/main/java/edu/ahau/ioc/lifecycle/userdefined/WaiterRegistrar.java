package edu.ahau.ioc.lifecycle.userdefined;

import edu.ahau.ioc.lifecycle.userdefined.bean.Waiter;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;

/**
 * @author zhangxuna
 * @date 2021-11-14 22:36
 */
@Component
public class WaiterRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        System.out.println("进入MyImportBeanDefinitionRegister");
        registry.registerBeanDefinition("waiter", new RootBeanDefinition(Waiter.class));
    }
}
