package edu.ahau.mvc.service;

import edu.ahau.mvc.dao.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author zhangxuna
 * @date 2021-12-21 14:13
 */
@Service
public class UserService {
    @Autowired
    private IUserDao userDao;

    public List<Map<String, Object>> qryUsers() {
        return userDao.qryUsers();
    }
}
