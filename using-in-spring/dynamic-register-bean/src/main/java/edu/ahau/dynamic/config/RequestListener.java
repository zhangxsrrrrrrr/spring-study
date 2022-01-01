package edu.ahau.dynamic.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * @author zhangxuna
 * @date 2021-12-29 17:13
 */
@WebListener//此注解声明此类为listener，无需再进行配置，唯一注意的是，使用注解的方式声明Listener时，需要在main函数类上添加
public class RequestListener  implements ServletRequestListener {

    public static Integer count = 0;
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        ServletContext aa = sre.getServletContext();
        System.out.println("访问次数为"+count);
        count++;
    }

}