package trucking.entity;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Alex on 15.08.2017.
 */
@Setter
@Getter
@Entity
@Table(name = "contract")
@Access(AccessType.FIELD)
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    StringProperty numberContract= new SimpleStringProperty();

    @Column(name = "numberContract")
    @Access(value = AccessType.PROPERTY)
    public String getNumberContract(){
        return numberContract.get();
    }

    public void setNumberContract(String str){
        numberContract.set(str);
    }


    @Column(name = "date")
    Date date;

    DoubleProperty price= new SimpleDoubleProperty();

    @Column(name = "cargoWeignt")
    Double cargoWeight;

    @Column(name = "our_car")
    boolean ourCar;

    @ManyToOne()
    @JoinColumn(name = "id_driver")
    Driver driver;

    @ManyToOne()
    @JoinColumn(name = "id_car")
    Car car;

    @ManyToOne()
    @JoinColumn(name = "id_company")
    Company company;

    @OneToMany(mappedBy = "contract",cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
    List<Trip> tripList;

    @OneToMany(mappedBy = "contract",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    List<PaymantOfContract> paymantOfContractList;

    @Column(name = "price")
    @Access(value = AccessType.PROPERTY)
    public Double getPrice() {
        return price.get();
    }
    public void setPrice(Double price){
        this.price.set(price);
    }

    /*public DoubleProperty priceProperty(){
        return price;
    }*/

    public Contract(String numberContract, Date date, double price, double cargoWeight, boolean ourCar, Driver driver, Car car, Company company) {
        setNumberContract( numberContract);
        this.date = date;
        setPrice(price);
        this.cargoWeight = cargoWeight;
        this.ourCar = ourCar;
        this.driver = driver;
        this.car = car;
        this.company = company;
    }

    public Contract() {
    }

    public Contract(Date date, Double price, Double cargoWeight) {
        this.date = date;
        setPrice(price);
        this.cargoWeight = cargoWeight;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                ", numberContract='" + numberContract + '\'' +
                ", date=" + date +
                ", price=" + price +
                ", cargoWeight=" + cargoWeight +
                ", ourCar=" + ourCar +
                ", driver=" + driver +
                ", car=" + car +
                ", company=" + company +
                '}';
    }
}
