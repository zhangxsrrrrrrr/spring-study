package edu.ahau.mvc.anno.config;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import edu.ahau.mvc.anno.interceptor.DemoInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.List;

/**
 * @author zhangxuna
 * @date 2021-12-21 15:13
 */
@Configuration
@ComponentScan(value = {"edu.ahau.mvc.anno"}, includeFilters = {
        @ComponentScan.Filter(value = {Controller.class})
})
@EnableWebMvc
@EnableAsync
public class WebAppConfig extends WebMvcConfigurationSupport {
    @Bean
    public InternalResourceViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/pages/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new DemoInterceptor()).addPathPatterns("/asd");
        super.addInterceptors(registry);
    }


    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter jsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        converters.add(jsonHttpMessageConverter);
        super.configureMessageConverters(converters);
    }
}
