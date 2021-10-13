package edu.ahau.thinking.in.spring.bean.factory;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.security.PublicKey;

/**
 *  * 默认{@link edu.ahau.thinking.in.spring.bean.factory.UserFactory} 实现
 *
 * @author zhangxuna
 * @create 2021-10-12 12:59
 * @description
 *
 * 执行顺序：
 * 由@PostConstruct，UserFactory初始化中....
 * 实现InitializingBean接口，在设置属性后初始化....
 * 由自定义，UserFactory初始化中....
 */
public class DefaultUserFactory implements UserFactory, InitializingBean, DisposableBean {
    @PostConstruct
    public void init() {
        System.out.println("由@PostConstruct，UserFactory初始化中....");
    }

    @Override
    public void initUserFactory() {
        System.out.println("由自定义，UserFactory初始化中....");
    }

    // 实现InitializingBean接口，在设置属性后初始化
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("实现InitializingBean接口，在设置属性后初始化....");
    }

    @Override
    @PreDestroy
    public void preDestroy() {
        System.out.println("由@PreDestroy，UserFactory销毁中....");
    }

    @Override
    public void destroy(){
        System.out.println("由DisposableBean接口，UserFactory销毁中....");
    }

    @Override
    public void destroyFactory() {
        System.out.println("自定义，UserFactory销毁中....");
    }

    @Override
    protected void finalize() throws Throwable{
        System.out.println("当前 DefaultUserFactory 对象正在被回收。。。");
    }
}
