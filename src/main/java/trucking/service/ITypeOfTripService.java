package trucking.service;

import trucking.entity.TypeOfTrip;

import java.util.List;

/**
 * Created by Alex on 15.08.2017.
 */
public interface ITypeOfTripService {
    TypeOfTrip save(TypeOfTrip typeOfTrip);
    TypeOfTrip get(long id);
    List<TypeOfTrip> getAll();
    void delete(TypeOfTrip typeOfTrip);
    void  delete(long id);
}
