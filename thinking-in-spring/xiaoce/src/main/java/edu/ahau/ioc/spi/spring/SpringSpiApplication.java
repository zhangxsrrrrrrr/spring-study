package edu.ahau.ioc.spi.spring;

import edu.ahau.ioc.spi.DemoDao;
import org.springframework.core.io.support.SpringFactoriesLoader;

import java.util.List;

/**
 *
 * 使用Spring的Api,可以获取到接口下面的实现类
 *  {@link SpringFactoriesLoader#loadFactories}
 *
 * @author zhangxuna
 * @date 2021-11-06 23:23
 */
public class SpringSpiApplication {
    public static void main(String[] args) {
        List<DemoDao> demoDaos = SpringFactoriesLoader.loadFactories(DemoDao.class, SpringSpiApplication.class.getClassLoader());
        demoDaos.forEach(System.out::println);
        System.out.println("------------------------");

        // 只加载全限定类名
        List<String> daoClassNames = SpringFactoriesLoader.loadFactoryNames(DemoDao.class, SpringSpiApplication.class.getClassLoader());

        daoClassNames.forEach(System.out::println);


    }
}
