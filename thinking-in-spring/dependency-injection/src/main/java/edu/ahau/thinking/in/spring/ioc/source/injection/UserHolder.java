package edu.ahau.thinking.in.spring.ioc.source.injection;

import edu.ahau.thinking.in.spring.ioc.overview.domain.User;

/**
 * 管理维护{@link User}User对象
 *
 * @author zhangxuna
 * @date 2021-10-16 14:25
 */
public class UserHolder {

    private User user;

    public UserHolder() {
    }

    public UserHolder(User user) {
        this.user = user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "UserHolder{" +
                "user=" + user +
                '}';
    }
}
