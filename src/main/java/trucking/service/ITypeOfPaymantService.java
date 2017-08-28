package trucking.service;

import trucking.entity.TypeOfPaymant;

import java.util.List;

/**
 * Created by Alex on 15.08.2017.
 */
public interface ITypeOfPaymantService {
    TypeOfPaymant save(TypeOfPaymant typeOfPaymant);
    List<TypeOfPaymant> getAll();
    void delete(TypeOfPaymant typeOfPaymant);
    void delete(long id);
}
