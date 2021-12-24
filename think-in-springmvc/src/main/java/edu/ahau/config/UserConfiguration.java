package edu.ahau.config;

import edu.ahau.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhangxuna
 * @date 2021-12-20 17:28
 */
@Configuration
public class UserConfiguration {
    @Bean
    public UserService userService() {
        return new UserService();
    }
}
