package edu.ahau.dao.transaction.annotation;

import edu.ahau.dao.transaction.annotation.config.DeclarativeTransactionConfiguration;
import edu.ahau.dao.transaction.annotation.service.RService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhangxuna
 * @date 2021-11-22 17:28
 */
public class TransactionAnnotationQuickStart {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(DeclarativeTransactionConfiguration.class);
        RService bean = applicationContext.getBean(RService.class);
        bean.register();
    }
}
