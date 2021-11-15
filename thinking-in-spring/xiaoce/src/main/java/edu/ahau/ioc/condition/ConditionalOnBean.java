package edu.ahau.ioc.condition;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * @author zhangxuna
 * @date 2021-11-03 17:21
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Conditional(OnBeanCondition.class)
public @interface ConditionalOnBean {
    Class<?>[] value() default {};

    String[] beanNames() default {};
}
