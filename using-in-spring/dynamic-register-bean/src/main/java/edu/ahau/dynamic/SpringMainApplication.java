package edu.ahau.dynamic;

import edu.ahau.dynamic.config.RequestListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author zhangxuna
 * @date 2021-12-28 17:34
 */
@SpringBootApplication
@ServletComponentScan(basePackageClasses = RequestListener.class)
public class SpringMainApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringMainApplication.class, args);
    }
}
