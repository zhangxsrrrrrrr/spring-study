package edu.ahau.ioc.eventlistener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author zhangxuna
 * @date 2021-11-03 15:14
 */
@Component
public class SmsSenderListener implements ApplicationListener<RegisterSuccessEvent> {
    @Override
    public void onApplicationEvent(RegisterSuccessEvent event) {
        System.out.println("监听到用户注册成功");
    }
}
