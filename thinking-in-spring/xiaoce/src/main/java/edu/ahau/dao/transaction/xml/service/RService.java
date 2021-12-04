package edu.ahau.dao.transaction.xml.service;

import edu.ahau.aop.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhangxuna
 * @date 2021-11-25 15:37
 */
@Service
public class RService {
    @Autowired
    AService aService;

    @Transactional
    public void register() {
        // 持久化操作 ......
        System.out.println("register 注册用户 ......");
        aService.addPoint();
    }
}
