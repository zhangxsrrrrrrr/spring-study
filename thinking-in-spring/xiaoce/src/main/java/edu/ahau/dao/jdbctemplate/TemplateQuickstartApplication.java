package edu.ahau.dao.jdbctemplate;

import edu.ahau.dao.jdbctemplate.bean.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

/**
 * @author zhangxuna
 * @date 2021-11-22 11:16
 */
public class TemplateQuickstartApplication {
    public static void main(String[] args) {
        //数据源的模型类
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/spring-dao?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai");
        dataSource.setUsername("root");
        dataSource.setPassword("root");

        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);

        List<User> query = jdbcTemplate.query("select id, name from tbl_user", new BeanPropertyRowMapper<>(User.class));
        System.out.println(query.toString());

    }
}
