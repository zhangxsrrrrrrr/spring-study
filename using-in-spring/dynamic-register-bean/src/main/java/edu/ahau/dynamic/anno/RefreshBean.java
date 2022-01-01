package edu.ahau.dynamic.anno;

import java.lang.annotation.*;

/**
 * @author zhangxuna
 * @date 2021-12-28 22:51
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RefreshBean {
}
