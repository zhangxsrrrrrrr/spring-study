package edu.ahau.dynamic.controller;

import com.alibaba.druid.pool.DruidDataSource;
import edu.ahau.dynamic.event.DynamicEvent;
import edu.ahau.dynamic.service.DataSourceService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author zhangxuna
 * @date 2021-12-28 21:40
 */
@RestController
public class DemoController implements BeanFactoryAware, ApplicationContextAware {

    private DefaultListableBeanFactory beanFactory;

    private ConfigurableApplicationContext ctx;

    @Autowired
    DataSourceService dataSourceService;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = (DefaultListableBeanFactory) beanFactory;
    }

    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        this.ctx = (ConfigurableApplicationContext) ctx;
    }

    @GetMapping(value = "/getdbs")
    public String getResource() {
        Map<String, DruidDataSource> beansOfType = beanFactory.getBeansOfType(DruidDataSource.class);
        System.out.println(beansOfType);

        dataSourceService.printDataSources();
        return "hehe";
    }

    @RequestMapping("/register1")
    public String registerByBeanDefinition() {
        beanFactory.removeBeanDefinition("db3");
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(DruidDataSource.class);
        builder.addPropertyValue("driverClassName", "com.mysql.jdbc.Driver");
        builder.addPropertyValue("url", "jdbc:mysql://localhost:3306/db3?characterEncoding=utf8");
        builder.addPropertyValue("username", "root");
        builder.addPropertyValue("password", "root");
        builder.setScope(ConfigurableListableBeanFactory.SCOPE_SINGLETON);
        this.beanFactory.registerBeanDefinition("db3", builder.getBeanDefinition());
        return "success";
    }

    // 基于SingletonFactory
    @RequestMapping("/register2")
    public String registerBySingletonFactory() {
        if (beanFactory.containsBeanDefinition("db3"))
        beanFactory.removeBeanDefinition("db3");
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/db3?characterEncoding=utf8");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        System.out.println("db3 创建完成！");
        beanFactory.registerSingleton("db3", dataSource);

        ctx.publishEvent(new DynamicEvent(ctx));
        return "success";
    }
}
