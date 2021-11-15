package edu.ahau.aop.aspect.service.log;

import java.lang.annotation.*;

/**
 * @author zhangxuna
 * @date 2021-11-15 14:49
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Log {
}
