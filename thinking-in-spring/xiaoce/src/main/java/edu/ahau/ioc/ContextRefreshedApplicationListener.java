package edu.ahau.ioc;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author zhangxuna
 * @date 2021-11-03 14:51
 */
@Component
public class ContextRefreshedApplicationListener {
    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("ContextRefreshedEvent 被我监听到了");
    }
}
