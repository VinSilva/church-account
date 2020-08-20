package br.com.church.account.repository;

import br.com.church.account.dto.ExpensesDto;
import br.com.church.account.model.ExpenseEntity;
import br.com.church.account.model.LoginEntity;
import br.com.church.account.repository.mapper.ExpensesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class ExpensesRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<ExpenseEntity> findAll(){
        String query = "select * from EXPENSE";
        List<ExpenseEntity> entitieList = jdbcTemplate.query(query, new ExpensesMapper());
        return entitieList;
    }

    public ExpenseEntity findById(long id) {
        Object[] parameters = new Object[]{id};
        ExpenseEntity entity = jdbcTemplate.queryForObject("select * from EXPENSE where id = ?", parameters, new ExpensesMapper());
        return entity;
    }

    public void delete(long id) {

        String query = "delete from EXPENSE where ID = ?";
        Object [] parameters = new Object[]{id};
        jdbcTemplate.update(query,parameters);
    }

    public ExpenseEntity save(ExpensesDto expensesDto){
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String query = "insert into EXPENSE(NAME, RESPONSIBLE, AMOUNT, CREATION_DATE) VALUES (?, ?, ?, ?)";
        java.sql.Date sqlDate = new java.sql.Date(expensesDto.getCreationDate().getTime());

        jdbcTemplate.update(
                connection -> {
                    PreparedStatement PreparedStatement = connection
                            .prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                    //setando valores das colunas  name e password que serão inseridas no banco de dados
                    PreparedStatement.setString(1, expensesDto.getName());
                    PreparedStatement.setString(2, expensesDto.getResponsible());
                    PreparedStatement.setDouble(3, expensesDto.getAmount());
                    PreparedStatement.setDate(4, sqlDate);

                    return PreparedStatement;
                },

                keyHolder);

        ExpenseEntity expenseEntity = findById(keyHolder.getKey().longValue());

        return expenseEntity;
    }

}


