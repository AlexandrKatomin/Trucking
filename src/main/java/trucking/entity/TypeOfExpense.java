package trucking.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Alex on 15.08.2017.
 */
@Getter
@Setter
@Entity
@Table(name = "typeOfExpense")
public class TypeOfExpense extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(name = "type")
    String type;

    @OneToMany(mappedBy = "typeOfExpense",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    List<Expense> expenseList;

    public TypeOfExpense() {
    }

    public TypeOfExpense(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return  type ;
    }
}
