package edu.ahau.dynamic.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

/**
 * @author zhangxuna
 * @date 2021-12-28 22:59
 */
public class DynamicEvent extends ApplicationContextEvent {

    public DynamicEvent(ApplicationContext source) {
        super(source);
    }
}
