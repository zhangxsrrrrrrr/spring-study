package edu.ahau.ioc.lifecycle;

import edu.ahau.ioc.lifecycle.bean.Cat;
import edu.ahau.ioc.lifecycle.bean.Person;
import edu.ahau.ioc.lifecycle.config.LifecycleSourceConfiguration;
import edu.ahau.ioc.lifecycle.postprocessor.LifecycleDestructionPostProcessor;
import edu.ahau.ioc.lifecycle.postprocessor.LifecycleNameReadPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author zhangxuna
 * @date 2021-11-07 17:32
 */
@Component
public class LifecycleSourceAnnotationApplication {

    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(LifecycleSourceAnnotationApplication.class);
        ctx.register(LifecycleSourceConfiguration.class);
        ctx.register(LifecycleNameReadPostProcessor.class);
        ctx.register(LifecycleDestructionPostProcessor.class);

        // 与上面一致，不再重复贴出
        System.out.println("================准备刷新IOC容器==================");

        ctx.refresh();

        System.out.println("================IOC容器刷新完毕==================");

        ctx.start();

        System.out.println("================IOC容器启动完成==================");

        Person person = ctx.getBean(Person.class);
        System.out.println(person);
        Cat cat = ctx.getBean(Cat.class);
        System.out.println(cat);

        System.out.println("================准备停止IOC容器==================");

        ctx.stop();

        System.out.println("================IOC容器停止成功==================");

        ctx.close();
    }
}
