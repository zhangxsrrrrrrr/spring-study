package edu.ahau.ioc.eventlistener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author zhangxuna
 * @date 2021-11-03 15:15
 */
@Component
public class MessageSenderListener {
    @EventListener
    public void onRegisterSuccess(RegisterSuccessEvent event) {
        System.out.println("监听到用户注册成功，发送站内信。。。");
    }
}
