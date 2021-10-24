package edu.ahau.thinking.in.spring.ioc.source.injection;

import edu.ahau.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author zhangxuna
 * @date 2021-10-16 14:40
 */
public class AnnotationDependencySetterInjectionDemo {

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext()) {
          annotationConfigApplicationContext.register(AnnotationDependencySetterInjectionDemo.class);

            XmlBeanDefinitionReader xmlReader = new XmlBeanDefinitionReader(annotationConfigApplicationContext);
            xmlReader.loadBeanDefinitions("classpath:/META-INF/dependency-looKup-context.xml");
            annotationConfigApplicationContext.registerBeanDefinition("userHolder", createBeanDefinition());


            UserHolder bean = annotationConfigApplicationContext.getBean(UserHolder.class);
            System.out.println(bean);
        }
    }

    @Bean("userHolder")
    public UserHolder userHolder(User user) {
        UserHolder userHolder = new UserHolder();
        userHolder.setUser(user);
        return userHolder;
    }

    public static BeanDefinition createBeanDefinition() {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(UserHolder.class);
        beanDefinitionBuilder.addPropertyReference("user", "superUser");
        return beanDefinitionBuilder.getBeanDefinition();
    }
}
