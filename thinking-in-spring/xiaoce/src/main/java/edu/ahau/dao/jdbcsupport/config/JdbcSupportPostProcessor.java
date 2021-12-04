package edu.ahau.dao.jdbcsupport.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

/**
 * @author zhangxuna
 * @date 2021-11-22 13:53
 */
@Component
public class JdbcSupportPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof JdbcDaoSupport) {
            JdbcDaoSupport bean1 = (JdbcDaoSupport) bean;
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setUrl("jdbc:mysql://localhost:3306/spring-dao?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai");
            dataSource.setUsername("root");
            dataSource.setPassword("root");
            dataSource.setDriverClassName("com.mysql.jdbc.Driver");
            bean1.setDataSource(dataSource);
            System.out.println(beanName);
        }
        return  bean;
    }


}
