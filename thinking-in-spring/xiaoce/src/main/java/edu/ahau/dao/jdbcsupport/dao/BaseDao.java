package edu.ahau.dao.jdbcsupport.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @author zhangxuna
 * @date 2021-11-22 15:17
 */
@Component
public class BaseDao extends JdbcDaoSupport {
    public void setMyDataSource(DataSource dataSource){
        super.setDataSource(dataSource);
    }
}
