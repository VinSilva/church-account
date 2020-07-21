package br.com.church.account.service;

import br.com.church.account.model.LoginEntity;
import br.com.church.account.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {

    @Autowired
    LoginRepository loginRepository;

    public void saveLogin(LoginEntity login){
        loginRepository.save(login);
    }

    public List<LoginEntity> ListLogin(){
        return (List<LoginEntity>) loginRepository.findAll();
    }
}
