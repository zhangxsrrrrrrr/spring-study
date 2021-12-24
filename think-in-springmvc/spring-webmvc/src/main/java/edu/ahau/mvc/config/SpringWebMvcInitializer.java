package edu.ahau.mvc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author zhangxuna
 * @date 2021-12-21 11:22
 */
public class SpringWebMvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    // 把 Service 、Dao 等类都放到根容器
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfiguration.class};
    }

    //表现层的 Controller 及相关的组件都放到 Servlet 的子容器中
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{ProjectBeanConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
