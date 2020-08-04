package br.com.church.account.repository.mapper;

import br.com.church.account.model.ExpenseEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExpensesMapper implements RowMapper<ExpenseEntity> {


    @Override
    public ExpenseEntity mapRow(ResultSet resultSet, int i) throws SQLException {

        ExpenseEntity expenseEntity = new ExpenseEntity();

	expenseEntity.setID(resultSet.getLong("ID"));
	expenseEntity.setName(resultSet.getString("NAME"));
	expenseEntity.setResponsible(resultSet.getString("RESPONSIBLE"));
	expenseEntity.setAmount(resultSet.getDouble("AMOUNT"));

	return expenseEntity;
    }
}
