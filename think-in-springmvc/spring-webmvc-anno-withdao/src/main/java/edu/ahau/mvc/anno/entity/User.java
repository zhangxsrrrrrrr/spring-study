package edu.ahau.mvc.anno.entity;

import java.util.Date;

/**
 * @author zhangxuna
 * @date 2021-12-22 9:57
 */
public class User {
    private String username;
    private String password;
    private Date date;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", date=" + date +
                '}';
    }
}
