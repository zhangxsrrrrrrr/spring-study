package edu.ahau.dao.transaction.annotation.service;

import edu.ahau.dao.jdbctemplate.bean.User;
import edu.ahau.dao.transaction.annotation.dao.impl.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
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
    }
}
