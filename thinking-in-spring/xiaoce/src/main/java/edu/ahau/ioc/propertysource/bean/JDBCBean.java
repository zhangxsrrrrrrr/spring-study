package edu.ahau.ioc.propertysource.bean;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author zhangxuna
 * @date 2021-11-04 13:51
 */
@Component
@Data
@ToString
public class JDBCBean {
    @Value("${jdbc.username}")
    private String name;
    @Value("${jdbc.password}")
    private String password;

    @Value("${yml.name}")
    private String name1;
}
