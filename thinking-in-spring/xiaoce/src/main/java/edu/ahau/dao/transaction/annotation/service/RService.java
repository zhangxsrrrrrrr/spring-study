package edu.ahau.dao.transaction.annotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * @author zhangxuna
 * @date 2021-11-25 15:37
 */
@Service
public class RService {
    @Autowired
    AService aService;

    @Transactional(propagation = Propagation.REQUIRED)
    public void register() {
//        int i = 1/0;
        System.out.println(TransactionSynchronizationManager.getCurrentTransactionName());
        // 持久化操作 ......
        System.out.println("register 注册用户 ......");
        aService.addPoint();
    }
}
