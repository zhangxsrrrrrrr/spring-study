package edu.ahau.dao.jdbcsupport.dao.impl;

import edu.ahau.dao.jdbcsupport.dao.BaseDao;
import edu.ahau.dao.jdbcsupport.dao.UserDao;
import edu.ahau.dao.jdbctemplate.bean.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhangxuna
 * @date 2021-11-22 11:53
 */
@Repository
public class UserDaoImpl extends BaseDao implements UserDao {

//    @Resource(name = "getDataSource")
//     public void setMyDataSource(DataSource dataSource) {
//        // 赋值给父类
//        super.setDataSource(dataSource);
//    }
    @Override
    public List<User> qryUser() {
        return this.getJdbcTemplate().query("select id, name from tbl_user", new BeanPropertyRowMapper<>(User.class));
    }

}
