package edu.ahau.thinking.in.spring.ioc.scope;

import edu.ahau.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

/**
 * 自定义 Scope 实例
 *
 * @author zhangxuna
 * @date 2021-10-24 21:27
 */
public class ThreadLocalScopeDemo {

    @Bean
    @Scope(ThreadLocalScope.SCOPE_NAME)
    public User user() {
        User user = new User();
        user.setAge((int) Thread.currentThread().getId());
        return user;
    }

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext()) {
            annotationConfigApplicationContext.register(ThreadLocalScopeDemo.class);
            annotationConfigApplicationContext.addBeanFactoryPostProcessor(beanFactory -> {
                // 注册自定义Scope
                beanFactory.registerScope(ThreadLocalScope.SCOPE_NAME, new ThreadLocalScope());
            });
            annotationConfigApplicationContext.refresh();
            for (int i = 0; i < 5; i++) {
                new Thread(()->{
                    System.out.println("线程号："+Thread.currentThread().getId()+"--->"+annotationConfigApplicationContext.getBean(User.class).hashCode());
                }).start();
            }
        }
    }
}
