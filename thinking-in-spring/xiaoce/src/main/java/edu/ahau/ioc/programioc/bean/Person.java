package edu.ahau.ioc.programioc.bean;

/**
 * @author zhangxuna
 * @date 2021-11-05 17:18
 */

import lombok.ToString;
import org.springframework.stereotype.Component;

@ToString
@Component
public class Person {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
