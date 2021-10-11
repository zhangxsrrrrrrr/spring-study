package edu.ahau.thinking.in.spring.ioc.overview.domain;

/**
 * @author zhangxuna
 * @create 2021-10-10 17:19
 * @description TODO
 */

import edu.ahau.thinking.in.spring.ioc.overview.annotation.Super;

@Super
public class SuperUser extends User{
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "address='" + address + '\'' +
                '}';
    }
}
