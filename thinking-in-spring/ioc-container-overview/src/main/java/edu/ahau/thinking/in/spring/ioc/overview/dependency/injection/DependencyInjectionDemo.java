package edu.ahau.thinking.in.spring.ioc.overview.dependency.injection;

import edu.ahau.thinking.in.spring.ioc.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zhangxuna
 * @create 2021-10-10 18:11
 * @description 依赖注入
 */
public class DependencyInjectionDemo {
    public static void main(String[] args) {
        // 配置XML配置文件
        // 启动Spring的应用上下文
        BeanFactory context = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");
        UserRepository repository = (UserRepository) context.getBean("userRepository");
        /*
         * 依赖注入
         **/
        System.out.println("注入的BeanFactory实则是---->"+repository.getBeanFactory()); //org.springframework.beans.factory.support.DefaultListableBeanFactory@3fb6a447: defining beans [user,objectFactory,superUser,userRepository]; root of factory hierarchy
        System.out.println(repository.getBeanFactory() == context);   // false


        //
        ObjectFactory<ApplicationContext> objFactory = repository.getObjFactory();
        System.out.println(objFactory.getObject() == context); // true
        System.out.println(objFactory.getObject()); // true

        System.out.println(repository.getBeanFactoryObjectFactory().getObject() == context);
    }


    private static void whoIsIocContainer(UserRepository repository, ApplicationContext context) {
        // ConfigurableApplicationContext <- ApplicationContext <- BeanFactory
//         依赖查找
        System.out.println(context.getBean(BeanFactory.class)); //NoSuchBeanDefinitionException

        // ApplicationContext is BeanFactory
    }
}
