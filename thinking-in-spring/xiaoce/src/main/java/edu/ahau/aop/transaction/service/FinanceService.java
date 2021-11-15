package edu.ahau.aop.transaction.service;

import edu.ahau.aop.transaction.annotation.Transactional;
import edu.ahau.aop.transaction.dao.FinanceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhangxuna
 * @date 2021-11-15 17:10
 */
@Service
public class FinanceService {

    @Autowired
    FinanceDao financeDao;

    @Transactional
    public void transfer(Long source, Long target, int money) {
        financeDao.subtractMoney(source, money);
        int i = 1 / 0;
        financeDao.addMoney(target, money);
    }
}