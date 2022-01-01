package com.linkedbear.spring.datasource.controller;

import com.linkedbear.spring.datasource.service.DataSourceService;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Map;

@RestController
public class RegisterDataSourceController implements BeanFactoryAware, ApplicationContextAware {
    
    private DefaultListableBeanFactory beanFactory;
    
    private ConfigurableApplicationContext ctx;
    
    @GetMapping("/getDataSources")
    public String getDataSources() {
        Map<String, DataSource> dataSourceMap = beanFactory.getBeansOfType(DataSource.class);
        dataSourceMap.forEach((s, dataSource) -> {
            System.out.println(s + " ======== " + dataSource);
        });
        /*
        DataSourceService dataSourceService = beanFactory.getBean(DataSourceService.class);
        dataSourceService.printDataSources();
        */
        return "success";
    }

    /**
     *
     * BeanDefinition注册
     * @author zhangxuna
     * @date 2021/12/27  21:34
     **/
    @GetMapping("/register1")
    public String register1() {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(HikariDataSource.class);
        builder.addPropertyReference("driverClassName", "com.mysql.jdbc.Driver");
        builder.addPropertyReference("jdbcUrl", "jdbc:mysql://localhost:3306/db3?characterEncoding=utf8");
        builder.addPropertyReference("username", "root");
        builder.addPropertyReference("password", "root");
        // builder.setScope(ConfigurableListableBeanFactory.SCOPE_SINGLETON);
        beanFactory.registerBeanDefinition("db3", builder.getBeanDefinition());
        return "success";
    }

    /**
     *
     * registerSingleton注册，autowireBean刷新
     *
     * @author zhangxuna
     * @date 2021/12/27  21:35
     **/
    @GetMapping("/register2")
    public String register2() throws SQLException {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/db3?characterEncoding=utf8");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.getConnection();
        System.out.println("db3 创建完成！");
        beanFactory.registerSingleton("db3", dataSource);
        beanFactory.autowireBean(beanFactory.getBean(DataSourceService.class));
        return "success";
    }

    @GetMapping("/register3")
    public String register3() throws SQLException {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/db3?characterEncoding=utf8&useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.getConnection();
        System.out.println("db3 创建完成！");
//        ctx.getBeanFactory().registerSingleton("db3", dataSource);
        ctx.refresh();
//        ctx.publishEvent(new DynamicRegisterEvent(ctx));
        return "success";
    }
    
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = (DefaultListableBeanFactory) beanFactory;
    }
    
    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        this.ctx = (ConfigurableApplicationContext) ctx;
    }
}
