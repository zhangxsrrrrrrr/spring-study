package edu.ahau.ioc.eventlistener;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

/**
 *
 * 发布回调，获取事件发布
 * @author zhangxuna
 * @date 2021-11-03 15:16
 */
@Service
public class RegisterService implements ApplicationEventPublisherAware {

    ApplicationEventPublisher publisher;

    public void testApplication(String name){
        publisher.publishEvent(new RegisterSuccessEvent(name));
    }
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        publisher = applicationEventPublisher;
    }
}
