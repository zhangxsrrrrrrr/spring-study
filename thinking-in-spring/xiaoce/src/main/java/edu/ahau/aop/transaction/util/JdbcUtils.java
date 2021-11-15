package edu.ahau.aop.transaction.util;


import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author zhangxuna
 * @date 2021-11-15 17:05
 */
public class JdbcUtils {
    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/test?characterEncoding=utf8&useSSL=false";

    private static ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<>();
    public static Connection getConnection() {
        if (connectionThreadLocal.get() != null) {
            return connectionThreadLocal.get();
        }
        Connection connection;
        try {
            connection = (Connection) DriverManager.getConnection(JDBC_URL, "root", "root");
            connectionThreadLocal.set(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static void remove() {
        connectionThreadLocal.remove();
    }
}
