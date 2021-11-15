package edu.ahau.aop.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author zhangxuna
 * @date 2021-11-15 9:38
 */
public class CglibEnhancerDemo {
    public static void main(String[] args) {
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(new SuperMan());
        proxyInstance.eat("beef");
    }



    /**
     * 抽象一个角色
     **/
    interface Human {
        void eat(String food);
        String getBelief();
    }

    /**
     *真实角色，实现业务
     *
     */
    static class SuperMan implements Human {

        @Override
        public void eat(String food) {
            System.out.println("超人吃"+food);
        }

        @Override
        public String getBelief() {
            return "I can fly!";
        }
    }

    static class ProxyFactory{
        public static Object getProxyInstance(Object object) {
           return  Enhancer.create(object.getClass(), new MethodInterceptor() {
               @Override
               public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                   if ("eat".equals(method.getName())) {
                       System.out.println("吃东西前洗了手。。。。");
                   }
                   if (objects != null && objects.length > 0) {
                       if ("beef".equals(objects[0])) {
                           System.out.println("超人不吃牛肉,并且强行转换成蔬菜");
                           objects[0] = "蔬菜";
                       }
                   }
//                   return method.invoke(object, objects);
                   return methodProxy.invokeSuper(o, objects);
               }
           });
        }
    }
}

