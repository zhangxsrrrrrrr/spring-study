package edu.ahau.ioc.lifecycle.bean;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author zhangxuna
 * @date 2021-11-07 16:45
 */
@Component
@Data
@ToString
public class Cat {

    @Value("miaomiao")
    private String name;

    @Autowired
    private Person master;

    // getter setter toString
}