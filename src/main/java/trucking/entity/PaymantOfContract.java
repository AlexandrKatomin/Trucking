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
@Table(name = "paymantOfContract")
public class PaymantOfContract extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(name = "dateOfPaymant")
    Date dateOfPaymant;

    @Column(name = "summ")
    Double summ;

    @ManyToOne()
    @JoinColumn(name = "id_contract")
    Contract contract;

    @ManyToOne()
    @JoinColumn(name = "id_typeOfPaymant")
    TypeOfPaymant typeOfPaymant;



    public PaymantOfContract() {
    }

    public PaymantOfContract(Date dateOfPaymant, Double summ, Contract contract, TypeOfPaymant typeOfPaymant) {
        this.dateOfPaymant = dateOfPaymant;
        this.summ = summ;
        this.contract = contract;
        this.typeOfPaymant = typeOfPaymant;
    }

    @Override
    public String toString() {
        return "PaymantOfContract{" +
                "id=" + id +
                ", dateOfPaymant=" + dateOfPaymant +
                ", summ=" + summ +
                ", contract=" + contract +
                ", typeOfPaymant=" + typeOfPaymant +
                '}';
    }
}
