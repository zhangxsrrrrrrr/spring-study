package edu.ahau.thinking.in.spring.ioc.source.annotation;

import java.lang.annotation.*;

/**
 * @author zhangxuna
 * @date 2021-10-21 8:28
 */
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface InjectedUser {
}
