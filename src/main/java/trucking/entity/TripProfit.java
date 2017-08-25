package trucking.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Alex on 15.08.2017.
 */
@Getter
@Setter
@Entity
@Table(name = "tripProfit")
public class TripProfit extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(name = "totalIncome")
    Double totalIncome;

    @Column(name = "totalExpence")
    Double totalExpense;

    @Column(name = "profit")
    Double profit;

    @ManyToOne()
    @JoinColumn(name = "id_circleTrip")
    CircleTrip circleTrip;

    public TripProfit() {
    }

    public TripProfit(Double totalIncome, Double totalExpense, Double profit, CircleTrip circleTrip) {
        this.totalIncome = totalIncome;
        this.totalExpense = totalExpense;
        this.profit = profit;
        this.circleTrip = circleTrip;
    }

    @Override
    public String toString() {
        return "TripProfit{" +
                "id=" + id +
                ", totalIncome=" + totalIncome +
                ", totalExpense=" + totalExpense +
                ", profit=" + profit +
                ", circleTrip=" + circleTrip +
                '}';
    }
}
