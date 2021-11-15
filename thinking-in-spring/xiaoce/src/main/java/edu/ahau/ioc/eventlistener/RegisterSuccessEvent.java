package edu.ahau.ioc.eventlistener;

import org.springframework.context.ApplicationEvent;

/**
 * @author zhangxuna
 * @date 2021-11-03 15:13
 */
public class RegisterSuccessEvent extends ApplicationEvent {
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public RegisterSuccessEvent(Object source) {
        super(source);
    }
}
