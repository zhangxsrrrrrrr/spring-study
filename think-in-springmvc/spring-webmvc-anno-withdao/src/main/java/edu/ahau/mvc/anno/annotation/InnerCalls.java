package edu.ahau.mvc.anno.annotation;

import java.lang.annotation.*;

/**
 * @author zhangxuna
 * @date 2021-12-21 17:48
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface InnerCalls {
}
