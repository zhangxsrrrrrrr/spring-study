package edu.ahau.aop.aspect.service.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author zhangxuna
 * @date 2021-11-15 13:42
 */
@Component
@Aspect
public class Logger {

    @Before("@annotation(edu.ahau.aop.aspect.service.log.Log))")
    public void beforePrint(JoinPoint joinPoint) {
//        System.out.println("getTarget:  "+joinPoint.getTarget());
//        System.out.println("getThis:  "+joinPoint.getThis());

//        System.out.println(Arrays.toString(joinPoint.getArgs()));


        System.out.println("Logger beforePrint run ......");
    }

//    @After("execution(public void edu.ahau.aop.aspect.service.FinanceService.addMoney(double))")
    public void afterPrint() {
        System.out.println("Logger afterPrint run ......");
    }

    public void afterReturningPrint() {
        System.out.println("Logger afterReturningPrint run ......");
    }

    public void afterThrowingPrint() {
        System.out.println("Logger afterThrowingPrint run ......");
    }

//    @Around("execution(public void edu.ahau.aop.aspect.service.FinanceService.addMoney(double))")
    public Object aroundPrint(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Logger aroundPrint before run ......");
        try {
            Object retVal = joinPoint.proceed();
            System.out.println("Logger aroundPrint afterReturning run ......");
            return retVal;
        } catch (Throwable e) {
            System.out.println("Logger aroundPrint afterThrowing run ......");
            throw e;
        } finally {
            System.out.println("Logger aroundPrint after run ......");
        }
    }
}