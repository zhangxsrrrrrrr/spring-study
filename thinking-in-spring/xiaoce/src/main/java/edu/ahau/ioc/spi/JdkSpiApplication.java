package edu.ahau.ioc.spi;

import java.util.ServiceLoader;

/**
 * @author zhangxuna
 * @date 2021-11-06 22:16
 */
public class JdkSpiApplication {
    public static void main(String[] args) {
        ServiceLoader<DemoDao> serviceLoader = ServiceLoader.load(DemoDao.class);
        serviceLoader.iterator().forEachRemaining(dao -> {
            System.out.println(dao);
        });
    }
}
