package edu.ahau.ioc.eventlistener.playload;

import edu.ahau.ioc.programioc.bean.Person;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhangxuna
 * @date 2021-11-07 13:50
 */
public class PayLoadApplication implements ApplicationEventPublisherAware {

    private static ApplicationEventPublisher publisher;

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(PayLoadApplication.class)) {
            applicationContext.addApplicationListener(new PayloadObjectApplicationListener());
            applicationContext.addApplicationListener(new PayloadIntegerApplicationListener());

            // 广播事件(可以使用回调的ApplicationEventPublisher，也可以使用applicationContext里面的事件发布)
            applicationContext.publishEvent("hahaha");
            applicationContext.publishEvent(123456789);
            applicationContext.publishEvent(new Person());
        }
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        publisher = applicationEventPublisher;
    }
}
