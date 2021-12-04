package edu.ahau.dao.transaction.programe;

import edu.ahau.dao.transaction.programe.config.JdbcTemplateConfig;
import edu.ahau.dao.transaction.programe.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhangxuna
 * @date 2021-11-22 16:20
 */
public class TranscationProgrameQuickStart {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(JdbcTemplateConfig.class);
        UserService bean = applicationContext.getBean(UserService.class);
        bean.saveAndQuery();
    }
}
