package trucking.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Alex on 15.08.2017.
 */
@Getter
@Setter
@Entity
@Table(name = "expense")
public class Expense extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(name = "summ")
    Double summ;

    @Column(name = "dateExpense")
    Date dateExpense;

    @Column(name = "description")
    String description;

    @ManyToOne()
    @JoinColumn(name = "id_typeOfExpense")
    TypeOfExpense typeOfExpense;

    @ManyToOne()
    @JoinColumn(name = "id_circleTrip")
    CircleTrip circleTrip;


    public Expense() {
    }

    public Expense(Double summ, Date dateExpense, String description, TypeOfExpense typeOfExpense, CircleTrip circleTrip) {
        this.summ = summ;
        this.dateExpense = dateExpense;
        this.description = description;
        this.typeOfExpense = typeOfExpense;
        this.circleTrip = circleTrip;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", summ=" + summ +
                ", dateExpense=" + dateExpense +
                ", description='" + description + '\'' +
                ", typeOfExpense=" + typeOfExpense +
                ", circleTrip=" + circleTrip +
                '}';
    }
}
