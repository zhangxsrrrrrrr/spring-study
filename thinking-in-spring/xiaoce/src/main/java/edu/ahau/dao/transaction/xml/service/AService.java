package edu.ahau.dao.transaction.xml.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhangxuna
 * @date 2021-11-25 15:36
 */
@Service
public class AService {

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addPoint() {
        System.out.println("addPoint 添加积分 ......");
    }
}
