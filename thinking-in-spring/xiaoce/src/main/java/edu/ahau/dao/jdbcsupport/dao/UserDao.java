package edu.ahau.dao.jdbcsupport.dao;

import edu.ahau.dao.jdbctemplate.bean.User;

import java.util.List;

/**
 * @author zhangxuna
 * @date 2021-11-22 11:52
 */
public interface UserDao {
    List<User> qryUser( );
}
