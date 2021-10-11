package edu.ahau.thinking.in.spring.ioc.overview.domain;

import org.springframework.beans.factory.FactoryBean;

import java.security.spec.DSAPrivateKeySpec;

/**
 * @author zhangxuna
 * @create 2021-10-10 16:22
 * @description 用户类
 */
public class User {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


}
