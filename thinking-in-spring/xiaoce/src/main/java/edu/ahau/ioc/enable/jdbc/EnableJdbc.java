package edu.ahau.ioc.enable.jdbc;

import org.springframework.stereotype.Indexed;

import java.lang.annotation.*;

/**
 * @author zhangxuna
 * @date 2021-11-06 17:37
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Indexed
public @interface EnableJdbc {
    String value() default "";
}
