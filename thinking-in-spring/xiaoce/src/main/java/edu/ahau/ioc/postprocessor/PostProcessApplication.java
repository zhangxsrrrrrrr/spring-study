package edu.ahau.ioc.postprocessor;

import edu.ahau.ioc.postprocessor.bean.Dog;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

/**
 * @author zhangxuna
 * @date 2021-11-05 10:15
 */
public class PostProcessApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(PostProcessApplication.class);
        applicationContext.addBeanFactoryPostProcessor(processor -> {
            processor.addBeanPostProcessor(new AnimalBeanPostProcessor());
        });
        applicationContext.refresh();
        System.out.println(Arrays.toString(applicationContext.getBeanDefinitionNames()));
    }
    @Bean
    public Dog dog(){
        return new Dog();
    }
}
