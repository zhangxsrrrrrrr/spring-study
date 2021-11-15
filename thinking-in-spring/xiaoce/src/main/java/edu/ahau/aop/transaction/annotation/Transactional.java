package edu.ahau.aop.transaction.annotation;

import java.lang.annotation.*;

/**
 * @author zhangxuna
 * @date 2021-11-15 17:19
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Transactional {

}
