package trucking.service;

import trucking.entity.Expense;

import java.util.List;

/**
 * Created by Alex on 15.08.2017.
 */
public interface IExpenseService {
    Expense save(Expense expense);
    Expense get(long id);
    List<Expense> getAll();
    void delete(Expense expense);
    void delete(long id);
}
