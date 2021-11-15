package edu.ahau.aop.transaction.log;

import edu.ahau.aop.transaction.util.JdbcUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.sql.Connection;

/**
 * @author zhangxuna
 * @date 2021-11-15 17:20
 */
@Component
@Aspect
public class Logger {
    @Around("@annotation(edu.ahau.aop.transaction.annotation.Transactional)")
    public Object doWithTransaction(ProceedingJoinPoint joinPoint) throws Throwable {
        Connection connection = JdbcUtils.getConnection();
        // 开启事务
        connection.setAutoCommit(false);
        try {
            Object retval = joinPoint.proceed();
            // 方法执行成功，提交事务
            connection.commit();
            return retval;
        } catch (Throwable e) {
            // 方法出现异常，回滚事务
            connection.rollback();
            throw e;
        } finally {
            // 最后关闭连接，释放资源
            JdbcUtils.remove();
        }
    }
}