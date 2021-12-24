package edu.ahau.mvc.anno.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhangxuna
 * @date 2021-12-22 8:45
 */
public class DemoInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long start = System.currentTimeMillis();
        request.setAttribute("start", start);
        System.out.println("DemoInterceptor preHandle ......");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("DemoInterceptor postHandle ......");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        long end = System.currentTimeMillis();
        long start = (long) request.getAttribute("start");
        System.out.println(end - start);
        System.out.println("DemoInterceptor afterCompletion ......");
    }
}
