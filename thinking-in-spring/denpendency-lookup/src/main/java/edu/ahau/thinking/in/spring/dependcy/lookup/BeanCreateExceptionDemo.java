package edu.ahau.thinking.in.spring.dependcy.lookup;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhangxuna
 * @date 2021-10-15 23:35
 */
public class BeanCreateExceptionDemo {
    public static void main(String[] args) {
       AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
       annotationConfigApplicationContext.register(BeanCreateExceptionDemo.class);
       BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(POJO.class);
       annotationConfigApplicationContext.registerBeanDefinition("pojo", builder.getBeanDefinition());
       annotationConfigApplicationContext.refresh();
       annotationConfigApplicationContext.getBean("pojo");
       annotationConfigApplicationContext.close();
    }

    class POJO implements InitializingBean {

        @Override
        public void afterPropertiesSet() throws Exception {
             throw new Exception("bean cuowu");
        }
    }
}
