package edu.ahau.ioc.propertysource;

import edu.ahau.ioc.propertysource.bean.JDBCBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhangxuna
 * @date 2021-11-04 13:52
 */
public class PropertiesApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(JdbcPropertiesConfiguration.class);
        applicationContext.refresh();
        JDBCBean bean = applicationContext.getBean(JDBCBean.class);
        System.out.println(bean.toString());
    }
}
