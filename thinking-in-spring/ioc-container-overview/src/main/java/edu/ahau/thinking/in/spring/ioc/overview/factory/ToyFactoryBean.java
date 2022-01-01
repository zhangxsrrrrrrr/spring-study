package edu.ahau.thinking.in.spring.ioc.overview.factory;

import edu.ahau.thinking.in.spring.ioc.overview.factory.entity.Child;
import edu.ahau.thinking.in.spring.ioc.overview.factory.toy.Ball;
import edu.ahau.thinking.in.spring.ioc.overview.factory.toy.Car;
import edu.ahau.thinking.in.spring.ioc.overview.factory.toy.Toy;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zhangxuna
 * @date 2021-12-29 16:24
 */
@Component
public class ToyFactoryBean implements FactoryBean<Toy> {
    @Autowired
    private Child child;

    @Override
    public Toy getObject() throws Exception {
        switch (child.getWantToy()) {
            case "car":
                return new Car("xiaoqiche");
            case "ball":
                return new Ball("xiaoqiu");
            default:
                return null;
        }
    }

    @Override
    public Class<Toy> getObjectType() {
        return Toy.class;
    }

    public void setChild(Child child) {
        this.child = child;
    }

}
