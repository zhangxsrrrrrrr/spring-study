package edu.ahau.thinking.in.spring.ioc.overview.domain;

import lombok.Data;
import org.springframework.beans.factory.BeanNameAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangxuna
 * @create 2021-10-10 16:22
 * @description 用户类
 */
@Data
public class User implements BeanNameAware {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", beanName='" + beanName + '\'' +
                ", workCities=" + Arrays.toString(workCities) +
                ", cityList=" + cityList +
                '}';
    }

    private transient String beanName;

    private City[] workCities;
    private List<City> cityList;

    public String getBeanName() {
        return beanName;
    }

    public City[] getWorkCities() {
        return workCities;
    }

    public void setWorkCities(City[] workCities) {
        this.workCities = workCities;
    }

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }

    public static User createUser() {
        User user = new User();
        user.setAge(12);
        user.setName("zasn");
        return user;
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User() {
    }

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


    @PostConstruct
    public void initialize() {
        System.out.println("用户对象"+beanName+"初始化....");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("用户对象"+beanName+"销毁。。。");
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }
}
