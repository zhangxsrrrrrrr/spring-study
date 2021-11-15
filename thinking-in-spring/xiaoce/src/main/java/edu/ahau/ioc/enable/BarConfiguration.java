package edu.ahau.ioc.enable;

import edu.ahau.ioc.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;

/**
 * @author zhangxuna
 * @date 2021-11-03 16:06
 */
public class BarConfiguration {
    @Bean
    @ConditionalOnBean(Boss.class)
    public Bar aaaabar(){
        return new Bar();
    }
}
