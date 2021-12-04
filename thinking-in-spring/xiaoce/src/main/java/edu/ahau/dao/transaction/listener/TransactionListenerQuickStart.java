package edu.ahau.dao.transaction.listener;

import edu.ahau.dao.transaction.listener.config.DeclarativeTransactionConfiguration;
import edu.ahau.dao.transaction.listener.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhangxuna
 * @date 2021-11-22 17:28
 */
public class TransactionListenerQuickStart {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(DeclarativeTransactionConfiguration.class);
        UserService bean = applicationContext.getBean(UserService.class);
        bean.saveAndQuery();
    }
}
