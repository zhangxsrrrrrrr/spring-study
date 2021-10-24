package edu.ahau.thinking.in.spring.ioc.source.injection;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhangxuna
 * @date 2021-10-16 14:40
 */
public class XmlDependencyConstructInjectionDemo {

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext()) {
          annotationConfigApplicationContext.register(XmlDependencyConstructInjectionDemo.class);

            XmlBeanDefinitionReader xmlReader = new XmlBeanDefinitionReader(annotationConfigApplicationContext);
            xmlReader.loadBeanDefinitions("classpath:/META-INF/construct-dependency-injection-setter-context.xml");
            annotationConfigApplicationContext.refresh();
            UserHolder bean = annotationConfigApplicationContext.getBean(UserHolder.class);
            System.out.println(bean);
        }
    }

//    @Bean("userHolder")
//    public UserHolder userHolder(User user) {
//        UserHolder userHolder = new UserHolder();
//        userHolder.setUser(user);
//        return userHolder;
//    }

    public static BeanDefinition createBeanDefinition() {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(UserHolder.class);
        beanDefinitionBuilder.addPropertyReference("user", "superUser");
        return beanDefinitionBuilder.getBeanDefinition();
    }
}
