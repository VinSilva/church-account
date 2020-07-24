package br.com.church.account.repository.mapper;

import br.com.church.account.model.LoginEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

    public class LoginMapper implements RowMapper<LoginEntity> {

    @Override
    public LoginEntity mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        LoginEntity loginEntity = new LoginEntity();
        loginEntity.setId(resultSet.getLong("ID"));
        loginEntity.setName(resultSet.getString("NAME"));
        loginEntity.setPassword(resultSet.getString("PASSWORD"));

        return loginEntity;
    }
}
