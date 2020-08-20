package br.com.church.account.controllers;

import br.com.church.account.dto.ExpensesDto;
import br.com.church.account.dto.LoginDto;
import br.com.church.account.model.ExpenseEntity;
import br.com.church.account.repository.ExpensesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("v1/expenses")
public class ExpensesController {

    @Autowired
    ExpensesRepository expensesRepository;

    @GetMapping("/all")
    public ResponseEntity<List<ExpenseEntity>> findAll(){
        return ResponseEntity.ok(expensesRepository.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<ExpenseEntity> findById(@PathVariable long id){
        ExpenseEntity entity = expensesRepository.findById(id);
        return ResponseEntity.ok(entity);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable long id){
        expensesRepository.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<ExpenseEntity> create(@RequestBody ExpensesDto expensesDto, UriComponentsBuilder uriBuilder){
        ExpenseEntity expenseEntity = expensesRepository.save(expensesDto);
        URI uri = uriBuilder.path("/v1/expenses/{id}").buildAndExpand(expenseEntity.getId()).toUri();
        return ResponseEntity.created(uri).body(expenseEntity);
    }
}
