package edu.ahau.mvc.dao;

import java.util.List;
import java.util.Map;

/**
 * @author zhangxuna
 * @date 2021-12-21 14:10
 */
public interface IUserDao {
    List<Map<String, Object>> qryUsers();
}
