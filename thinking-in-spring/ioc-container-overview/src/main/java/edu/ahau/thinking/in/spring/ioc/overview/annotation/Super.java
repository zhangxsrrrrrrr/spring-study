package edu.ahau.thinking.in.spring.ioc.overview.annotation;

import org.springframework.stereotype.Indexed;

import java.lang.annotation.*;

/**
 * @author zhangxuna
 * @create 2021-10-10 17:19
 * @description 超级
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Super {

}
