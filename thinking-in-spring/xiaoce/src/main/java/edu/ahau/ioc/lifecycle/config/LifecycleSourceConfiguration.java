package edu.ahau.ioc.lifecycle.config;

import edu.ahau.ioc.lifecycle.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhangxuna
 * @date 2021-11-07 17:04
 */
@Configuration
@ComponentScan("edu.ahau.ioc.lifecycle.bean")
public class LifecycleSourceConfiguration {

    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    public Person person() {
        Person person = new Person();
        person.setName("lisi");
        return person;
    }
}
