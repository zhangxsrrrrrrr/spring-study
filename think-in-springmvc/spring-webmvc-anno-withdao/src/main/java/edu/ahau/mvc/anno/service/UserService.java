package edu.ahau.mvc.anno.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author zhangxuna
 * @date 2021-12-21 15:12
 */
@Service
public class UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List<Map<String, Object>> qryUsers() {
        return jdbcTemplate.queryForList("select * from tbl_user");
    }
 }
