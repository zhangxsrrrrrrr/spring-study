package edu.ahau.thinking.in.spring.ioc.source.injection;

import edu.ahau.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhangxuna
 * @date 2021-10-19 20:13
 */
public class AnnotationDependencyInjectionResolutionDemo {
    @Autowired
    private User user;  // DependencyDescriptor ->
                        // 必须（required=true）
                        // 通过类型注入
                        // 依赖查找（处理）
                        // 字段名称
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext()) {
            applicationContext.register(AnnotationDependencyInjectionResolutionDemo.class);
            XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(applicationContext);


            reader.loadBeanDefinitions("classpath:/META-INF/dependency-injection-setter-context.xml");
            applicationContext.refresh();
            System.out.println(applicationContext.getBean(User.class));


        }
    }
}
