package edu.ahau.ioc.enable.jdbc.config;

import com.alibaba.druid.pool.DruidDataSource;
import edu.ahau.ioc.condition.ConditionalOnBean;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author zhangxuna
 * @date 2021-11-06 17:38
 */
@Configuration
public class JdbcConfiguration {
    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test?characterEncoding=utf8");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }

    @Bean
    @ConditionalOnBean(value = {DruidDataSource.class})
    public QueryRunner queryRunner(DataSource dataSource) {
        return new QueryRunner(dataSource);
    }

}
