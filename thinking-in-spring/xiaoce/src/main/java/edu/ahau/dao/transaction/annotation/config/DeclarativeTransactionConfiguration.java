package edu.ahau.dao.transaction.annotation.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * 使用注解必须要配置 TransactionManager
 *
 * @author zhangxuna
 * @date 2021-11-22 17:26
 */
@ComponentScan("edu.ahau.dao.transaction.annotation")
@Configuration
@EnableTransactionManagement
public class DeclarativeTransactionConfiguration {
    @Autowired
    private DataSource dataSource;
    @Bean
    public TransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }


    public static void main(String[] args) {
        String name = null;
        System.out.println("CARD_PIC="+name);
    }
}
