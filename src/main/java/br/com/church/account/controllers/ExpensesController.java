package br.com.church.account.controllers;


@RestController
@RequestMapping("v1/expense")
public class ExpensesController {


    @Autowired
    private ExpensesRepository expensesRepository;

    @GetMapping("/all")
    public ResponseEntity<List<ExpenseEntity>> listAll(){
        List<ExpenseEntity> list = expensesRepository.findAll();
        return ResponseEntity.ok(all);
    }
}
