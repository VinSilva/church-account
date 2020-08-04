package br.com.church.account.repository;

@Repository
public class ExpensesRepository {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<ExpenseEntity> findAll(){

        String query = "select * from EXPENSE";
        List<ExpenseEntity> entitiesList = jdbcTemplate.query(query, new ExpenseMapper());
        return entitiesList;
    }
}
