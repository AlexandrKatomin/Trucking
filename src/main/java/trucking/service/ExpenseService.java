package trucking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trucking.entity.Expense;
import trucking.repository.ExpenseRepository;

import java.util.List;

/**
 * Created by Alex on 24.08.2017.
 */
@Service("ExpenseService")
public class ExpenseService implements IExpenseService {
    @Autowired
    ExpenseRepository expenseRepository;
    @Override
    public Expense save(Expense expense) {
        return expenseRepository.save(expense);
    }

    @Override
    public Expense get(long id) {
        return expenseRepository.findOne(id);
    }

    @Override
    public List<Expense> getAll() {
        return expenseRepository.findAll();
    }

    @Override
    public void delete(Expense expense) {
        expenseRepository.delete(expense);
    }

    @Override
    public void delete(long id) {
        expenseRepository.delete(id);
    }
}
