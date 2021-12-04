package edu.ahau.dao.transaction.listener.service;

import edu.ahau.dao.jdbctemplate.bean.User;
import edu.ahau.dao.transaction.listener.dao.impl.UserDao;
import edu.ahau.dao.transaction.listener.listen.defined.MyTransactionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    ApplicationEventPublisher eventPublisher;

    @Transactional
    public void saveAndQuery() {
        User user = new User();
        user.setName("阿巴阿巴");
        user.setTel("123654789");

        userDao.insertUser(user);

//        int i = 1 / 0;

        userDao.insertUser(user);
        List<User> userList = userDao.selectAllUsers();
        System.out.println(userList);
//        eventPublisher.publishEvent(user);
        eventPublisher.publishEvent(new MyTransactionListener(user));
    }
}
