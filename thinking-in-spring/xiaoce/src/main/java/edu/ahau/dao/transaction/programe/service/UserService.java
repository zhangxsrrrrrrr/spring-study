package edu.ahau.dao.transaction.programe.service;

import edu.ahau.dao.jdbctemplate.bean.User;
import edu.ahau.dao.transaction.programe.dao.impl.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

/**
 * @author zhangxuna
 * @date 2021-11-22 16:19
 */
@Service
public class UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    TransactionTemplate transactionTemplate;

    public void saveAndQuery() {
        User user = new User();
        user.setName("阿巴阿巴");
        user.setTel("123654789");
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                userDao.insertUser(user);

                int i = 1 / 0;

                List<User> userList = userDao.selectAllUsers();
                System.out.println(userList);
            }
        });
    }
}
