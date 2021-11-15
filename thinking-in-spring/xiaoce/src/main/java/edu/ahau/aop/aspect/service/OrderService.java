package edu.ahau.aop.aspect.service;

import java.util.List;

/**
 * @author zhangxuna
 * @date 2021-11-15 13:40
 */
public interface OrderService {
    void createOrder();

    void deleteOrderById(String id);

    String getOrderById(String id);

    List<String> findAll();
}
