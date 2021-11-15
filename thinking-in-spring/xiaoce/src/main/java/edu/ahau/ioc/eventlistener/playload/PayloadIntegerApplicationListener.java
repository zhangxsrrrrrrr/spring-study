package edu.ahau.ioc.eventlistener.playload;

import org.springframework.context.ApplicationListener;
import org.springframework.context.PayloadApplicationEvent;

/**
 *
 * 创建一个PayloadObjectApplicationListener，监听所有的事件
 * 可以不用再去实现一个Listener
 *
 * @author zhangxuna
 * @date 2021-11-07 13:46
 */
public class PayloadIntegerApplicationListener implements ApplicationListener<PayloadApplicationEvent<Integer>> {

    @Override
    public void onApplicationEvent(PayloadApplicationEvent event) {
        System.out.println("监听到PayloadApplicationEvent <Integer>------> " + event.getPayload());
    }
}
