package trucking.repository;

import trucking.entity.TypeOfExpense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Alex on 15.08.2017.
 */
@Repository
public interface TypeOfExpenseRepository extends JpaRepository<TypeOfExpense,Long> {
}
