package edu.ahau.mvc.anno.advice;

import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * @author zhangxuna
 * @date 2021-12-22 9:53
 */
@ControllerAdvice
public class WebAdviceConfig {
    @InitBinder
    public void initBinder(WebDataBinder bind) {
        bind.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
    }
}
