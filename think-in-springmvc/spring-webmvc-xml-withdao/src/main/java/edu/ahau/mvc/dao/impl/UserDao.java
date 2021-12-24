package edu.ahau.mvc.dao.impl;

import edu.ahau.mvc.dao.IUserDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author zhangxuna
 * @date 2021-12-21 14:11
 */
@Repository
public class UserDao implements IUserDao {
    @Resource
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Map<String, Object>> qryUsers() {
        return jdbcTemplate.queryForList("select * from tbl_user");
    }
}
