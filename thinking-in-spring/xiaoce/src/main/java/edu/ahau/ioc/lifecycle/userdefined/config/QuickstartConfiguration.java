package edu.ahau.ioc.lifecycle.userdefined.config;

import edu.ahau.ioc.lifecycle.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhangxuna
 * @date 2021-11-14 22:33
 */
@Configuration
public class QuickstartConfiguration {
    @Bean
    public Person person() {
        return new Person();
    }
}