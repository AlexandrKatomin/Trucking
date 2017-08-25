package trucking.entity;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Alex on 15.08.2017.
 */


@Entity
@Table(name = "typeOfTrip")
@Access(AccessType.FIELD)
public class TypeOfTrip extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(name = "type")
    String type;

/*
    private StringProperty type=new SimpleStringProperty();
   public StringProperty typeProperty() {
        return type;
    }
    @Column(name = "type")
    @Access(value = AccessType.PROPERTY)
    public  String getType(){
        return type.get();
    }

    public void  setType(String type) {
        this.type.set(type);
    }*/

    @OneToMany(mappedBy = "typeOfTrip",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    List<Trip> tripList;

    public TypeOfTrip() {
    }

    /*public TypeOfTrip(SimpleStringProperty type) {
        this.type = type;
    }*/

    @Override
    public String toString() {
        return  type;
    }
}
