package br.com.church.account.repository;

import br.com.church.account.dto.DepositDto;
import br.com.church.account.model.DepositEntity;
import br.com.church.account.repository.mapper.DepositMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class DepositRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<DepositEntity> findAll(){
        String query = "select * from DEPOSIT";
        List<DepositEntity> entitieList = jdbcTemplate.query(query, new DepositMapper());
        return entitieList;
    }

    public List<DepositEntity> findByName(String name){
        Object[] object = new Object[]{name};
        String query = "select * from DEPOSIT where NAME = ?";
         return jdbcTemplate.query(query, object, new DepositMapper());
    }

    public DepositEntity findById(Long id){
        Object[] object = new Object[]{id};
        String query = "select * from DEPOSIT where id = ?";
        DepositEntity depositEntity = jdbcTemplate.queryForObject(query, object, new DepositMapper());
        return depositEntity;
    }

    public DepositEntity save(DepositDto depositDto){
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String query = "insert into DEPOSIT(DEPOSIT_DATE, NAME, TYPE, PAY_TYPE, AMOUNT) values (?, ?, ?, ?, ?)";

        jdbcTemplate.update(connection -> {
                    PreparedStatement PreparedStatement = connection
                            .prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

                    java.sql.Date sqlDate = new java.sql.Date(depositDto.getDeposit_date().getTime());
                    PreparedStatement.setDate(1, sqlDate);
                    PreparedStatement.setString(2, depositDto.getName());
                    PreparedStatement.setString(3, depositDto.getType());
                    PreparedStatement.setString(4, depositDto.getPay_type());
                    PreparedStatement.setDouble(5, depositDto.getAmount());


                    return PreparedStatement;
                }, keyHolder);
        DepositEntity depositEntity = this.findById(keyHolder.getKey().longValue());
        return depositEntity;
    }

    public void delete(Long id){
        String query = "delete from DEPOSIT where id = ?";

        jdbcTemplate.update(query, id);
    }

    public DepositEntity update(Long id, DepositDto depositDto){
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String query =  "update DEPOSIT set DEPOSIT_DATE = ?, NAME = ?, TYPE = ?, PAY_TYPE = ?, AMOUNT = ? where ID = ?";

        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            java.sql.Date sqlDate = new java.sql.Date(depositDto.getDeposit_date().getTime());

            preparedStatement.setDate(1, sqlDate);
            preparedStatement.setString(2, depositDto.getName());
            preparedStatement.setString(3, depositDto.getType());
            preparedStatement.setString(4, depositDto.getPay_type());
            preparedStatement.setDouble(5, depositDto.getAmount());
            preparedStatement.setLong(6, id);

            return preparedStatement;

        }, keyHolder);
        DepositEntity depositEntityUpdated = this.findById(id);
        return depositEntityUpdated;
    }

    public List<DepositEntity> showBalancePerPeriod(Date start, Date end){
        Object[] params = new Object[]{start, end};
        String query = "select * from DEPOSIT where DEPOSIT_DATE between ? and ?";
        return jdbcTemplate.query(query, params, new DepositMapper());
    }

    public Double showAmountPerPeriod(Date start, Date end){
        Object[] params = new Object[]{start, end};
        String query = "select sum(AMOUNT) as amount from DEPOSIT where DEPOSIT_DATE between ? and ?";
        return jdbcTemplate.queryForObject(query, params, (rs, row) -> rs.getDouble("amount"));
    }

    public List<DepositEntity> findDepositByNameAndType(String name, String type){
        Object[] params = new Object[]{"%"+name+"%", type};
        String query = "select * from DEPOSIT where NAME like ? and TYPE = ?";
        return jdbcTemplate.query(query, params, new DepositMapper());
    }
}