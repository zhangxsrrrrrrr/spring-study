package edu.ahau.mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author zhangxuna
 * @date 2021-12-21 11:13
 */
@Configuration
@ComponentScan("edu.ahau.mvc.controller")
public class ProjectBeanConfig {
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("pages/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}
