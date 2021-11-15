package edu.ahau.ioc.lifecycle.userdefined;

import edu.ahau.ioc.lifecycle.bean.Person;
import edu.ahau.ioc.lifecycle.userdefined.config.ComponentScanConfiguration;
import edu.ahau.ioc.lifecycle.userdefined.config.EnableTavern;
import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author zhangxuna
 * @date 2021-11-14 22:40
 */
@EnableTavern
@Component
public class BeanMainApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        BeanDefinition personDefinition = BeanDefinitionBuilder.rootBeanDefinition(Person.class)
                .addPropertyValue("name", "zhangsan").getBeanDefinition();
        ctx.registerBeanDefinition("person",personDefinition);
        ctx.refresh();

    }

    @Test
    public void test(){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(BeanMainApplication.class);
        ctx.register(ComponentScanConfiguration.class);
        ctx.refresh();
        System.out.println(Arrays.toString(ctx.getBeanDefinitionNames()));
        System.out.println(ctx.getType("waiter"));

    }

}
