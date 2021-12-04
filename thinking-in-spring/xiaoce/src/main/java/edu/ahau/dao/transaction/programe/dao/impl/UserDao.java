package edu.ahau.dao.transaction.programe.dao.impl;

import edu.ahau.dao.jdbctemplate.bean.User;
import edu.ahau.dao.transaction.programe.dao.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhangxuna
 * @date 2021-11-22 16:16
 */
@Repository
public class UserDao implements IUserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insertUser(User user) {
        return jdbcTemplate.update("insert into tbl_user (name, tel) values (?, ?)", user.getName(), user.getTel());
    }

    @Override
    public List<User> selectAllUsers() {
        return jdbcTemplate.query("select * from tbl_user", new BeanPropertyRowMapper<>(User.class));
    }
}
