package edu.ahau.dynamic.listen;

import edu.ahau.dynamic.anno.RefreshBean;
import edu.ahau.dynamic.event.DynamicEvent;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author zhangxuna
 * @date 2021-12-28 23:00
 */
@Component
public class DynamicListener implements ApplicationListener<DynamicEvent> {
    @Override
    public void onApplicationEvent(DynamicEvent dynamicEvent) {
        ApplicationContext ctx = dynamicEvent.getApplicationContext();
        AutowireCapableBeanFactory beanFactory = ctx.getAutowireCapableBeanFactory();
        Map<String, Object> beansMap = ctx.getBeansWithAnnotation(RefreshBean.class);
        beansMap.values().forEach(beanFactory::autowireBean);
    }
}
