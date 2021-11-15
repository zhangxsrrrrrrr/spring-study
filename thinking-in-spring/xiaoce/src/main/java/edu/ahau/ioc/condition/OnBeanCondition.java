package edu.ahau.ioc.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;
import java.util.Objects;

/**
 * @author zhangxuna
 * @date 2021-11-03 17:38
 */
public class OnBeanCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Map<String, Object> attributes = metadata.getAnnotationAttributes(ConditionalOnBean.class.getName());
        Class<?>[] classes = (Class<?>[]) attributes.get("value");
        for (Class<?> clazz : classes) {
            if (!Objects.requireNonNull(context.getBeanFactory()).containsBeanDefinition(clazz.getName())) {
                return false;
            }
        }
        String[] beanNames = (String[]) attributes.get("beanNames");
        for (String beanName : beanNames) {
            if (!context.getBeanFactory().containsBeanDefinition(beanName)) {
                return false;
            }
        }
        return true;
    }
}
