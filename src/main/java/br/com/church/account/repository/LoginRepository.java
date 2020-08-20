package br.com.church.account.repository;

import br.com.church.account.dto.LoginDto;
import br.com.church.account.model.LoginEntity;
import br.com.church.account.repository.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

@Repository
public class LoginRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<LoginEntity> findAll(){

        String query = "select * from LOGIN";
        List<LoginEntity> entitiesList = jdbcTemplate.query(query, new LoginMapper());
        return entitiesList;
    }



    //IGNORAR OS METODOS ABAIXO ######################################
    public LoginEntity findByName(String name){
        Object[] parameters = new Object[]{name};
        LoginEntity loginEntity = jdbcTemplate.queryForObject("select * from LOGIN WHERE NAME = ?", parameters, new LoginMapper());
        return loginEntity;

    }

    public LoginEntity findById(Long id){
        Object[] parameters = new Object[]{id};
        LoginEntity loginEntity = jdbcTemplate.queryForObject("select * from LOGIN WHERE ID = ?", parameters, new LoginMapper());
        return loginEntity;

    }
    
    public LoginEntity save(LoginDto loginDto)  {

        KeyHolder keyHolder = new GeneratedKeyHolder();
        String query = "insert into LOGIN (NAME, PASSWORD) values (? , ?)";

        jdbcTemplate.update(
                    connection -> {
                        PreparedStatement PreparedStatement = connection
                                .prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                        //setando valores das colunas  name e password que serão inseridas no banco de dados
                        PreparedStatement.setString(1, loginDto.getName());
                        PreparedStatement.setString(2, loginDto.getPassword());
                        return PreparedStatement;
                    },

                    keyHolder);

        LoginEntity loginEntity = findById(keyHolder.getKey().longValue());

        return loginEntity;
    }

    public void delete(Long id) {

        String query = "delete from LOGIN where ID = ?";
        Object [] parameters = new Object[]{id};
        jdbcTemplate.update(query,parameters);
    }
}
