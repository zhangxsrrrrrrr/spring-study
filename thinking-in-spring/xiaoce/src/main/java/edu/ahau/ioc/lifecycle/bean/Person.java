package edu.ahau.ioc.lifecycle.bean;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.Lifecycle;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author zhangxuna
 * @date 2021-11-07 16:44
 */
@Data
@ToString
@Component
public class Person implements InitializingBean, DisposableBean, Lifecycle {

    private String name;

    private boolean state = false;

    public Person() {
        System.out.println("Person constructor run ......");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Person @PostConstruct run ......");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Person InitializingBean run ......");
    }

    public void initMethod() {
        System.out.println("Person initMethod run ......");
    }

    @PreDestroy
    public void preDestory() {
        System.out.println("Person @PreDestroy run ......");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Person DisposableBean run ......");
    }

    public void destroyMethod() {
        System.out.println("Person destroyMethod run ......");
    }

    @Override
    public void start() {
        System.out.println("Person 睡醒起床了 ......");
        this.state = true;
    }

    @Override
    public void stop() {
        System.out.println("Person 睡觉去了 ......");
        this.state = false;
    }

    @Override
    public boolean isRunning() {
        return state;
    }

    // getter setter toString
}
