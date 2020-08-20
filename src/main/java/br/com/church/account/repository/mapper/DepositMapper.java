package br.com.church.account.repository.mapper;

import br.com.church.account.model.DepositEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;

public class DepositMapper implements RowMapper<DepositEntity> {

    @Override
    public DepositEntity mapRow(ResultSet resultSet, int i) throws java.sql.SQLException{
        DepositEntity depositEntity = new DepositEntity();

        depositEntity.setId(resultSet.getLong("ID"));
        depositEntity.setDeposit_date(resultSet.getDate("DEPOSIT_DATE"));
        depositEntity.setName(resultSet.getString("NAME"));
        depositEntity.setType(resultSet.getString("TYPE"));
        depositEntity.setPay_type(resultSet.getString("PAY_TYPE"));
        depositEntity.setAmount(resultSet.getDouble("AMOUNT"));

        return depositEntity;
    }
}
