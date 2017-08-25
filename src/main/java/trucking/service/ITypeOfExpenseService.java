package trucking.service;

import trucking.entity.TypeOfExpense;

import java.util.List;

/**
 * Created by Alex on 15.08.2017.
 */
public interface ITypeOfExpenseService {

    TypeOfExpense save(TypeOfExpense typeOfExpense);
    TypeOfExpense get(long id);
    List<TypeOfExpense> getAll();
    void delete(TypeOfExpense typeOfExpense);
    void delete(long id);
}
