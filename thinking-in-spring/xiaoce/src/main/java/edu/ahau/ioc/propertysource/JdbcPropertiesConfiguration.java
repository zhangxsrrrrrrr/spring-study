package edu.ahau.ioc.propertysource;

import edu.ahau.ioc.propertysource.yml.YmlPropertyFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author zhangxuna
 * @date 2021-11-04 13:49
 */
@Configuration
@ComponentScan("edu.ahau.ioc.propertysource")
@PropertySource("classpath:/jdbc.properties")
// factory 与
@PropertySource(value = "classpath:/jdbc.yaml",factory = YmlPropertyFactory.class)
public class JdbcPropertiesConfiguration {
}
