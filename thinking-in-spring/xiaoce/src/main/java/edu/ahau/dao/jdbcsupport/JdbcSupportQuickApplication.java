package edu.ahau.dao.jdbcsupport;

import edu.ahau.dao.jdbcsupport.config.JdbcTemplateConfiguration;
import edu.ahau.dao.jdbcsupport.dao.UserDao;
import edu.ahau.dao.jdbcsupport.dao.impl.UserDaoImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * @author zhangxuna
 * @date 2021-11-22 13:39
 */
public class JdbcSupportQuickApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(JdbcTemplateConfiguration.class);
        System.out.println(Arrays.toString(applicationContext.getBeanDefinitionNames()));
        UserDao bean = applicationContext.getBean(UserDaoImpl.class);
        System.out.println(bean.qryUser());
    }
}
