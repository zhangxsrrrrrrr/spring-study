package edu.ahau.aop.transaction;

import edu.ahau.aop.transaction.service.FinanceService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author zhangxuna
 * @date 2021-11-15 17:09
 */
@EnableAspectJAutoProxy
@ComponentScan("edu.ahau.aop.transaction")
public class TransactionApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(TransactionApplication.class);
        FinanceService financeService = ctx.getBean(FinanceService.class);
        financeService.transfer(1L, 2L, 100);
    }
}
