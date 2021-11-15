package edu.ahau.ioc.enable;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author zhangxuna
 * @date 2021-11-03 15:51
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented

@Import({ BarConfiguration.class, BarImportSelector.class, BartenderConfiguration.class})
public @interface EnableTavern {
}
