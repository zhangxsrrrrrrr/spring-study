package edu.ahau.dao.transaction.programe.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

/**
 * @author zhangxuna
 * @date 2021-11-22 17:21
 */
@Configuration
public class JdbcTransactionTemplate {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private TransactionManager transactionManager;
    @Bean
    public TransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public TransactionTemplate transactionTemplate(){
        return new TransactionTemplate((PlatformTransactionManager) transactionManager);
    }
}
