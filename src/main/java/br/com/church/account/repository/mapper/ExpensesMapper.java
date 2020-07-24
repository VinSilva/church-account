package br.com.church.account.repository.mapper;

import br.com.church.account.model.ExpenseEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExpensesMapper implements RowMapper<ExpenseEntity> {


    @Override
    public ExpenseEntity mapRow(ResultSet resultSet, int i) throws SQLException {
        return null;
    }
}
