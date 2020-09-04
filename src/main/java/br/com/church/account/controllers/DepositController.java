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
import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("v1/deposit")
public class DepositController {

    @Autowired
    DepositRepository depositRepository;

    @Autowired
    DepositService depositService;

    @GetMapping("/{id}")
    public ResponseEntity<DepositEntity> findById(@PathVariable Long id){
        return ResponseEntity.ok(depositRepository.findById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<DepositEntity>> findAll(){
        return ResponseEntity.ok(depositRepository.findAll());
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<DepositEntity>> findByName(@PathVariable String name){
        return ResponseEntity.ok(depositRepository.findByName(name));

    }

    @GetMapping("/balance")
    public ResponseEntity<List<DepositEntity>> showBalancePerPeriod(@RequestParam("start") Date start, @RequestParam("end") Date end){
        return ResponseEntity.ok(depositRepository.showBalancePerPeriod(start, end));
    }

    @GetMapping("/amount")
    public ResponseEntity<Double> showAmountPerPeriod(@RequestParam("start") Date start, @RequestParam("end") Date end){
        return ResponseEntity.ok(depositRepository.showAmountPerPeriod(start, end));
    }

    @GetMapping("/search")
    public ResponseEntity<List<DepositEntity>> findDepositByNameAndType(@RequestParam("name") String name, @RequestParam("type")String type){
        return ResponseEntity.ok(depositRepository.findDepositByNameAndType(name, type));
    }

    @PostMapping
    public ResponseEntity<DepositEntity> save(@RequestBody DepositDto depositDto, UriComponentsBuilder uriBuilder){
        DepositEntity depositEntity = depositService.save(depositDto);
        URI uri = uriBuilder.path("/v1/deposit/{id}").buildAndExpand(depositEntity.getId()).toUri();
        return ResponseEntity.created(uri).body(depositEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        depositRepository.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepositEntity> update(@PathVariable Long id, @RequestBody DepositDto depositDto, UriComponentsBuilder uriBuilder){
        DepositEntity depositEntityUpdated = depositRepository.update(id, depositDto);
        URI uri = uriBuilder.path("/v1/deposit/{id}").buildAndExpand(depositEntityUpdated.getId()).toUri();
        return ResponseEntity.created(uri).body(depositEntityUpdated);
    }
}
