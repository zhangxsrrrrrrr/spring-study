package edu.ahau.mvc.anno.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author zhangxuna
 * @date 2021-12-21 17:49
 */
@Component
@Aspect
public class SpringAopConfig {
    @Before("@annotation(edu.ahau.mvc.anno.annotation.InnerCalls))")
    public void beforePrint(JoinPoint joinPoint) {
    }
}
