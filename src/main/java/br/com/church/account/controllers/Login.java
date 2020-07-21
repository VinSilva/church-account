package br.com.church.account.controllers;

import br.com.church.account.dto.LoginDto;
import br.com.church.account.model.LoginEntity;
import br.com.church.account.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;
import java.util.List;

@RestController
@RequestMapping("v1/account")
public class Login {

    @Autowired
    LoginService service;

    @RequestMapping("/login")
    public ResponseEntity<List<LoginEntity>> postLogin(@RequestBody LoginDto login){
        System.out.println("Name: " + login.getName() + "\n" + "Password: " + login.getPassword());
        LoginEntity loginEntity = new LoginEntity();
        loginEntity.setName(login.getName());
        loginEntity.setPassword(login.getPassword());

        service.saveLogin(loginEntity);

        return ResponseEntity.ok(service.ListLogin());
    }
}
