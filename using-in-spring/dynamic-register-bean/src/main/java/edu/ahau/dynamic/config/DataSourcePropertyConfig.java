package edu.ahau.dynamic.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.*;
import org.springframework.web.context.annotation.SessionScope;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * @author zhangxuna
 * @date 2021-12-28 17:33
 */
@Configuration(proxyBeanMethods = true)
public class DataSourcePropertyConfig implements ImportBeanDefinitionRegistrar {
    private static final HashMap<String, DruidDataSource> dataSourceHashMap = new HashMap< >(3);

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.db1")
    @SessionScope(proxyMode = ScopedProxyMode.INTERFACES)
    public DataSource db1() {
        System.out.println("db1 creating ......");
        return new DruidDataSource();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.db2")
    @SessionScope(proxyMode = ScopedProxyMode.INTERFACES)
    public DataSource db2() {
        System.out.println("db2 creating ......");
        return new DruidDataSource();
    }

}
