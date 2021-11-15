package edu.ahau.thinking.in.spring.ioc.overview.domain;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;

import java.util.Arrays;

/**
 * @author zhangxuna
 * @create 2021-10-10 17:19
 * @description TODO
 */

public class SuperUser extends User implements BeanNameAware, BeanFactoryAware, BeanClassLoaderAware {

    private String address;

    ClassLoader classLoader;

    BeanFactory beanFactory;

    String beanName;

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
                '}'  +"User{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", beanName='" + getBeanName() + '\'' +
                ", workCities=" + Arrays.toString(getWorkCities()) +
                ", cityList=" + getCityList() +
                '}';

    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = beanName;
    }
}
