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
@Table(name = "circleTrip")
public class CircleTrip extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(name = "number")
    String number;

    @Column(name = "countOfDay")
    Integer countDay;

    @OneToMany(mappedBy = "circleTrip",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    List<Trip> tripList;

    @OneToMany(mappedBy = "circleTrip",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    List<TripProfit> tripProfitList;

    @OneToMany(mappedBy = "circleTrip",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    List<Expense> expenseList;

    public CircleTrip() {
    }

    public CircleTrip(String number, Integer countDay) {
        this.number = number;
        this.countDay = countDay;
    }

    @Override
    public String toString() {
        return  number;
    }
}


