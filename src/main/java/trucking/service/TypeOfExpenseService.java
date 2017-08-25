package trucking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trucking.entity.Expense;
import trucking.entity.TypeOfExpense;
import trucking.repository.ExpenseRepository;
import trucking.repository.TypeOfExpenseRepository;

import java.util.List;

/**
 * Created by Alex on 24.08.2017.
 */
@Service("TypeOfExpenseService")
public class TypeOfExpenseService implements ITypeOfExpenseService {
    @Autowired
    TypeOfExpenseRepository typeOfExpenseRepository;
    @Override
    public TypeOfExpense save(TypeOfExpense typeOfExpense) {
        return typeOfExpenseRepository.save(typeOfExpense);
    }

    @Override
    public TypeOfExpense get(long id) {
        return typeOfExpenseRepository.findOne(id);
    }

    @Override
    public List<TypeOfExpense> getAll() {
        return typeOfExpenseRepository.findAll();
    }

    @Override
    public void delete(TypeOfExpense typeOfExpense) {
        typeOfExpenseRepository.delete(typeOfExpense);
    }

    @Override
    public void delete(long id) {
        typeOfExpenseRepository.delete(id);
    }

}
