package trucking.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Alex on 15.08.2017.
 */
@Getter
@Setter
@Entity
@Table(name = "car")
public class Car extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(name = "model")
    String model;

    @Column(name = "civic_number")
    String civic_number;

    @Column(name = "birthday")
    Date birthday;

    @Column(name = "carryngCapacity")
    Double carryngCapacity;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "car", fetch = FetchType.LAZY)
    List<Contract> contractList;

    public Car() {
    }

    public Car(String model, String civic_number, Date birthday, double carryngCapacity) {
        this.model = model;
        this.civic_number = civic_number;
        this.birthday = birthday;
        this.carryngCapacity = carryngCapacity;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", civic_number='" + civic_number + '\'' +
                ", birthday=" + birthday +
                ", carryngCapacity=" + carryngCapacity +
                '}';
    }
}
