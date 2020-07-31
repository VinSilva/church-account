package br.com.church.account.controllers;

import br.com.church.account.dto.LoginDto;
import br.com.church.account.model.LoginEntity;
import br.com.church.account.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("v1/account")
public class LoginController {

    @Autowired
    private LoginRepository loginRepository;

    private String atributoGlobal = "";

    @GetMapping("/all") //teste commit
    public ResponseEntity<List<LoginEntity>> listAll(){
        List<LoginEntity> all = loginRepository.findAll();
        String atributoLocal = "";
        return ResponseEntity.ok(all);
    }

    @GetMapping("/{name}")
    public ResponseEntity<LoginDto> findLoginByName(@PathVariable("name") String name){
        return ResponseEntity.ok(new LoginDto(loginRepository.findByName(name)));
    }

    @PostMapping
    public ResponseEntity<LoginDto> create(@RequestBody LoginDto loginDto, UriComponentsBuilder uriBuilder){

        LoginEntity loginEntity = loginRepository.save(loginDto);
        URI uri = uriBuilder.path("/v1/account/{id}").buildAndExpand(loginEntity.getId()).toUri();
        return ResponseEntity.created(uri).body(new LoginDto(loginEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){

        loginRepository.delete(id);
        return ResponseEntity.ok().build();
    }



}
