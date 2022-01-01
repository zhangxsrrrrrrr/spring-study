package edu.ahau.thinking.in.spring.ioc.overview.factory.config;

import edu.ahau.thinking.in.spring.ioc.overview.factory.entity.Child;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhangxuna
 * @date 2022-01-01 23:42
 */
@Configuration
@ComponentScan("edu.ahau.thinking.in.spring.ioc.overview.factory")
public class BeanConfig {
    @Bean
    public Child child() {
        return new Child();
    }
}
