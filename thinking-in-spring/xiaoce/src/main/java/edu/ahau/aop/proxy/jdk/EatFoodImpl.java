package edu.ahau.aop.proxy.jdk;

/**
 * @author zhangxuna
 * @date 2021-11-12 16:58
 */
public class EatFoodImpl implements IEatFood{

    @Override
    public void eat(String foodName) {
        System.out.println("今天吃了" + foodName);
    }
}
