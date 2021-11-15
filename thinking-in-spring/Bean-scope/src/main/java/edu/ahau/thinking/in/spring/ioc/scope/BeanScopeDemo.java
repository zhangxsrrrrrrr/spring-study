package edu.ahau.thinking.in.spring.ioc.scope;

import edu.ahau.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.util.Map;

/**
 * Signleton Bean无论依赖查找还是依赖注入，均为同一对象
 * Prototype Bean无论依赖查找还是依赖注入，均为新生对象
 *
 * 如果依赖注入集合类型的对象，Singleton Bean和Prototype Bean均会存在一个
 * Prototype Bean 有别于其他的Prototype Bean
 *
 * 无论是Singleton Bean 还是Prototype Bean均会执行初始化方法回调
 * 但是只有Singleton Bean会执行销毁方法回调
 *
 *
 * @author zhangxuna
 * @date 2021-10-23 21:38
 */
public class BeanScopeDemo implements DisposableBean {
    @Bean
    @Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public static User singletonUser() {
        User user = new User();
        user.setAge((int) System.nanoTime());
        return user;
    }

    @Bean
    @Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public static User prototypeUser() {
        User user = new User();
        user.setAge((int) System.nanoTime());
        return user;
    }

    @Autowired
    @Qualifier("singletonUser")
    private User singletonUser;
    @Autowired
    @Qualifier("singletonUser")
    private User singletonUser1;

    @Autowired
    @Qualifier("prototypeUser")
    private User prototypeUser;
    @Autowired
    @Qualifier("prototypeUser")
    private User prototypeUser2;

    @Autowired
    private Map<String, User> users;

    @Autowired
    private ConfigurableListableBeanFactory beanFactory;  // Resolvable Dependency

    public static void main(String[] args) {

        AnnotationConfigApplicationContext beanContext = new AnnotationConfigApplicationContext();
        beanContext.register(BeanScopeDemo.class);
        // 添加生命周期管理
        beanContext.addBeanFactoryPostProcessor(beanFactory -> {
            beanFactory.addBeanPostProcessor(new BeanPostProcessor() {
                @Override
                public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                    System.out.printf("%s Bean名称：%s 在初始化后回调。。。%n", bean.getClass().getName(), beanName);
                    return bean;
                }
            });
        });
        beanContext.refresh();
        BeanScopeDemo demo = beanContext.getBean(BeanScopeDemo.class);
        System.out.println("prototype =====" + demo.prototypeUser);
        System.out.println("singletonUser  =====" + demo.singletonUser);
//        scopeBeanByLookup(beanContext);
//        scopeBeansByInjection(beanContext);


        beanContext.close();
    }

    private static void scopeBeansByInjection(AnnotationConfigApplicationContext beanContext) {
        BeanScopeDemo bean = beanContext.getBean(BeanScopeDemo.class);
        System.out.println("===============");
        System.out.println("prototypeUser    "+bean.prototypeUser);
        System.out.println("prototypeUser    "+bean.prototypeUser2);
        System.out.println("singletonUser    "+bean.singletonUser);
        System.out.println("singletonUser    "+bean.singletonUser1);

        System.out.println("map ："+ bean.users);
    }

    private static void scopeBeanByLookup(AnnotationConfigApplicationContext beanContext) {
        for (int i = 0; i < 3; i++) {
            System.out.println("singletonUser =========="+beanContext.getBean("singletonUser", User.class));
        }
        for (int i = 0; i < 3; i++) {
            System.out.println("prototypeUser =========="+beanContext.getBean("prototypeUser", User.class));
        }
    }


    @Override
    public void destroy() throws Exception {
        System.out.println("当前 BeanScopeDemo正在销毁中 ");
        this.prototypeUser.destroy();
        this.prototypeUser2.destroy();
        // 获取Prototype
        for (Map.Entry<String, User> entry : this.users.entrySet()) {
            String beanName = entry.getKey();
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);
            if (!beanDefinition.isSingleton()) {
                entry.getValue().destroy();
            }
        }
    }
}
