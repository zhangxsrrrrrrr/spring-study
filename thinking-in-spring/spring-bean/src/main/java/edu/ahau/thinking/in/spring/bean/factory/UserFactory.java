package edu.ahau.thinking.in.spring.bean.factory;

import edu.ahau.thinking.in.spring.ioc.overview.domain.User;

/**
 * @author zhangxuna
 * @create 2021-10-12 12:52
 * @description TODO
 */
public interface UserFactory {

    default User createUser() {
        return User.createUser();
    }

    void initUserFactory();

    void preDestroy();

    void destroy();
    void destroyFactory();
}