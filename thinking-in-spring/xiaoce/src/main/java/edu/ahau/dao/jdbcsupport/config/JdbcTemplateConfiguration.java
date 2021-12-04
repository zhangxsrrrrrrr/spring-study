package edu.ahau.dao.jdbcsupport.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * @author zhangxuna
 * @date 2021-11-22 11:54
 */
@ComponentScan("edu.ahau.dao.jdbcsupport")
@Configuration
public class JdbcTemplateConfiguration {

    @Bean
    public DataSource getDataSource() {
        //数据源的模型类
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/spring-dao?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return dataSource;
    }
}
