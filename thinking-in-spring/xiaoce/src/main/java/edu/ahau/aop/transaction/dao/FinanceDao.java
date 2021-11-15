package edu.ahau.aop.transaction.dao;


import com.mysql.jdbc.PreparedStatement;
import edu.ahau.aop.transaction.util.JdbcUtils;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author zhangxuna
 * @date 2021-11-15 17:03
 */
@Repository
public class FinanceDao {

    public void addMoney(Long id, int money) {
        try {
            Connection connection = JdbcUtils.getConnection();
            PreparedStatement preparedStatement = (PreparedStatement) connection
                    .prepareStatement("update tbl_employee set salary = salary + ? where id = ?");
            preparedStatement.setInt(1, money);
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void subtractMoney(Long id, int money) {
        try {
            Connection connection = JdbcUtils.getConnection();
            PreparedStatement preparedStatement = (PreparedStatement) connection
                    .prepareStatement("update tbl_employee set salary = salary - ? where id = ?");
            preparedStatement.setInt(1, money);
            preparedStatement.setLong(2, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
