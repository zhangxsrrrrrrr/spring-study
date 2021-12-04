package edu.ahau.dao.transaction.programe.dao;

import edu.ahau.dao.jdbctemplate.bean.User;

import java.util.List;

/**
 * @author zhangxuna
 * @date 2021-11-22 16:15
 */
public interface IUserDao {
    int insertUser(User user);
    List<User> selectAllUsers();
}
