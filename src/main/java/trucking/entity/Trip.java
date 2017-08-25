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
@Table(name = "trip")
public class Trip extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(name = "numberInCircleTrip")
    Integer numberInCircleTrip;

    @Column(name = "dateBegin")
    Date dateBegin;

    @Column(name = "dateEnd")
    Date dateEnd;

    @Column(name = "km")
    Double km;

    @Column(name = "fuel_consumption")
    Double fuel_consumption;

    @Column(name = "placeOfLoad")
    String placeOfLoad;

    @Column(name = "placeOfUnload")
    String placeOfUnload;

    @ManyToOne()
    @JoinColumn(name="id_circleTrip")
    CircleTrip circleTrip;

    @ManyToOne()
    @JoinColumn(name = "id_contract")
    Contract contract;

    @ManyToOne()
    @JoinColumn(name= "id_typeOfTrip")
    TypeOfTrip typeOfTrip;

    public Trip() {
    }

    public Trip(int numberInCircleTrip, Date dateBegin, Date dateEnd, double km, Double fuel_consumption, String placeOfLoad, String placeOfUnload, CircleTrip circleTrip, Contract contract, TypeOfTrip typeOfTrip) {
        this.numberInCircleTrip = numberInCircleTrip;
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
        this.km = km;
        this.fuel_consumption = fuel_consumption;
        this.placeOfLoad = placeOfLoad;
        this.placeOfUnload = placeOfUnload;
        this.circleTrip = circleTrip;
        this.contract = contract;
        this.typeOfTrip = typeOfTrip;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", numberInCircleTrip=" + numberInCircleTrip +
                ", dateBegin=" + dateBegin +
                ", dateEnd=" + dateEnd +
                ", km=" + km +
                ", fuel_consumption=" + fuel_consumption +
                ", placeOfLoad='" + placeOfLoad + '\'' +
                ", placeOfUnload='" + placeOfUnload + '\'' +
                ", circleTrip=" + circleTrip +
                ", contract=" + contract +
                ", typeOfTrip=" + typeOfTrip +
                '}';
    }
}
