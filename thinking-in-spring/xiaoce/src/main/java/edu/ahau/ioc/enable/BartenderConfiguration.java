package edu.ahau.ioc.enable;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhangxuna
 * @date 2021-11-03 16:11
 */
@Configuration
public class BartenderConfiguration {
    @Bean
    public Bartender zhangxiaosan() {
        return new Bartender("张小三");
    }

    @Bean
    public Bartender zhangdasan() {
        return new Bartender("张大三");
    }
}
