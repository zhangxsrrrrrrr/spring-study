package edu.ahau.aop.proxy.jdk;

import java.lang.reflect.Proxy;


/**
 * @author zhangxuna
 * @date 2021-11-12 16:56
 */
public class JDKProxyDemo {

    public static void main(String[] args) {
        Human proxyInstance = (Human)ProxyFactory.getProxyInstance(new SuperMan());
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
    static class SuperMan implements Human{

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
            Human o = (Human) Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), (proxy, method, args) -> {
                if ("eat".equals(method.getName())) {
                    System.out.println("吃东西前洗了手。。。。");
                }
                if (args != null && args.length > 0) {
                    if ("beef".equals(args[0])) {
                        System.out.println("超人不吃牛肉,并且强行转换成蔬菜");
                        args[0] = "蔬菜";
                    }
                }

                return method.invoke(object, args);
            });
            return  o;
        }
    }
}
