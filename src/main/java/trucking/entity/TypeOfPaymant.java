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
@Table(name = "typeOfPaymant")
public class TypeOfPaymant extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(name = "type")
    String type;

    @Column(name = "numberAccount")
    String numberAccount;

    @OneToMany(mappedBy = "typeOfPaymant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<PaymantOfContract> paymantOfContractList;

    public TypeOfPaymant() {
    }

    public TypeOfPaymant(String type, String numberAccount) {
        this.type = type;
        this.numberAccount = numberAccount;
    }

    @Override
    public String toString() {
        return type;
    }
}