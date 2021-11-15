package edu.ahau.aop.aspect;

import edu.ahau.aop.aspect.service.FinanceService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * @author zhangxuna
 * @date 2021-11-15 13:40
 */
public class XmlAspectApplication {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext();
        applicationContext.setConfigLocation("xmlaspect.xml");
        applicationContext.refresh();
        FinanceService service = applicationContext.getBean(FinanceService.class);
        service.addMoney(123.123);
        System.out.println(Arrays.toString(applicationContext.getBeanDefinitionNames()));
    }
}
