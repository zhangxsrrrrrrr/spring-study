package edu.ahau.dao.transaction.xml;

import edu.ahau.dao.transaction.xml.service.RService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zhangxuna
 * @date 2021-11-22 16:20
 */
public class TranscationQuickStart {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:dao/application-dao.xml");
        RService bean = applicationContext.getBean(RService.class);
        bean.register();
    }
}
