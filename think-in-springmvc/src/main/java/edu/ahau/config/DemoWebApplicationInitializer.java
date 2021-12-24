package edu.ahau.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.AbstractContextLoaderInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

/**
 * 取代 web.xml 初始化 spring 容器
 * 继承{@link AbstractContextLoaderInitializer} ，实现{@link WebApplicationInitializer}
 * AbstractContextLoaderInitializer这里面实现了大部分逻辑，我们要做的，只是如何创建 IOC 容器，使用哪些注解配置类，扫描哪些包，
 * @author zhangxuna
 * @date 2021-12-20 17:11
 */
public class DemoWebApplicationInitializer extends AbstractContextLoaderInitializer {
    @Override
    protected WebApplicationContext createRootApplicationContext() {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(UserConfiguration.class);
        return ctx;
    }
}
