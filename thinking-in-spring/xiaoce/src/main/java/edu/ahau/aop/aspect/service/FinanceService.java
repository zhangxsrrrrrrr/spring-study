package edu.ahau.aop.aspect.service;

import edu.ahau.aop.aspect.service.log.Log;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Component;

/**
 * @author zhangxuna
 * @date 2021-11-15 13:42
 */
@Component
public class FinanceService {

    @Log
    public void addMoney(double money) {
        System.out.println("FinanceService 收钱 === " + money);
    }

    public double subtractMoney(double money) {
        ( (FinanceService) AopContext.currentProxy()).addMoney(123);
        this.addMoney(123.123d);
        System.out.println("FinanceService 付钱 === " + money);
        return money;
    }

    public double getMoneyById(String id) {
        System.out.println("FinanceService 查询账户，id为" + id);
        return Math.random();
    }
}
