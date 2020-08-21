package br.com.church.account.controllers;

import br.com.church.account.dto.DepositDto;
import br.com.church.account.model.DepositEntity;
import br.com.church.account.repository.DepositRepository;
import br.com.church.account.services.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("v1/deposit")
public class DepositController {

    @Autowired
    DepositRepository depositRepository;

    @Autowired
    DepositService depositService;

    @GetMapping("/all")
    public ResponseEntity<List<DepositEntity>> findAll(){
        return ResponseEntity.ok(depositRepository.findAll());
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<DepositEntity>> findByName(@PathVariable String name){
        return ResponseEntity.ok(depositRepository.findByName(name));
    }

    @PostMapping
    public ResponseEntity<DepositEntity> save(@RequestBody DepositDto depositDto, UriComponentsBuilder uriBuilder){
        DepositEntity depositEntity = depositService.save(depositDto);
        URI uri = uriBuilder.path("/v1/deposit/{id}").buildAndExpand(depositEntity.getId()).toUri();
        return ResponseEntity.created(uri).body(depositEntity);
    }
}
