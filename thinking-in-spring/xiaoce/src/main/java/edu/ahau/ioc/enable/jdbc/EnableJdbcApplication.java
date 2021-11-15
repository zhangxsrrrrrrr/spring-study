package edu.ahau.ioc.enable.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhangxuna
 * @date 2021-11-06 17:42
 */
@EnableJdbc

@Configuration
public class EnableJdbcApplication {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(EnableJdbcApplication.class);
        DruidDataSource dataSource = ctx.getBean(DruidDataSource.class);
        System.out.println(dataSource.getUrl());
    }
}
