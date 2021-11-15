package edu.ahau.ioc.register;

import edu.ahau.ioc.enable.jdbc.EnableJdbc;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * @author zhangxuna
 * @date 2021-11-07 0:08
 */
@Configuration
@EnableJdbc
@PropertySource("classpath:jdbc.properties")
public class EnableJdbcApplication {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext()) {
            applicationContext.register(DataSourceRegisterPostProcessor.class);
            applicationContext.register(EnableJdbcApplication.class);
            applicationContext.refresh();
            DataSource bean = (DataSource) applicationContext.getBean("dataSource");
            System.out.println(bean);
        }
    }
}
