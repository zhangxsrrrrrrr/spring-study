package edu.ahau.injection.config;

import edu.ahau.injection.pojo.Dog;
import edu.ahau.lookup.pojo.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

/**
 * @author zhangxuna
 * @date 2022-01-01 12:12
 */
@Configuration(proxyBeanMethods = false)
@ComponentScan("edu.ahau.injection")
@PropertySource("classpath:application.properties")
public class BeanConfig {
    @Value("${my.name}")
    private String name;


    @Bean(name = "person")
    public Person person() {
        Person person = new Person();
        person.setName(name);
        return person;
    }
    @Bean(name = "person1")
    public Person person1() {
        Person person = new Person();
        person.setName(name);
        System.out.println("person 初始化");
        return person;
    }
    @Bean
    @Lazy
    public Dog dog() {
        Dog dog = new Dog();
        dog.setManagerName("asd");
        System.out.println("dog 初始化了");
        return dog;
    }
}
