package edu.ahau.ioc.basepackage;

import edu.ahau.ioc.condition.ConditionalOnBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * @author zhangxuna
 * @date 2021-11-03 22:37
 */
@Configuration
@ComponentScan(basePackageClasses = DemoService.class,
excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = ConditionalOnBean.class))
public class BasePackageClassConfiguration {
}
