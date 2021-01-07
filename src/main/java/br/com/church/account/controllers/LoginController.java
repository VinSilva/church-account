package br.com.church.account.controllers;

import br.com.church.account.dto.LoginDto;
import br.com.church.account.model.LoginEntity;
import br.com.church.account.repository.LoginRepository;
import br.com.church.account.repository.LoginRepositoryHibernate;
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
    private LoginRepositoryHibernate loginRepositoryHibernate;

    private String atributoGlobal = "";

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/all")
    public ResponseEntity<List<LoginEntity>> listAll(){

        List<LoginEntity> all = loginRepositoryHibernate.findAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<LoginDto>> findLoginByName(@PathVariable("name") String name){

        return ResponseEntity.ok( LoginDto.converterToList(loginRepositoryHibernate.findByName(name)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){

        loginRepositoryHibernate.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public ResponseEntity<LoginDto> create(@RequestBody LoginEntity loginEntity, UriComponentsBuilder uriBuilder){

        LoginEntity loginEntitySaved = loginRepositoryHibernate.save(loginEntity);
        URI uri = uriBuilder.path("/v1/account/{id}").buildAndExpand(loginEntitySaved.getId()).toUri();
        return ResponseEntity.created(uri).body(new LoginDto(loginEntitySaved));
    }
}
