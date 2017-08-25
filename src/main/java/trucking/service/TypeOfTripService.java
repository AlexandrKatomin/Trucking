package trucking.service;

import trucking.entity.TypeOfTrip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trucking.repository.TypeOfTripRepository;

import java.util.List;

/**
 * Created by Alex on 15.08.2017.
 */
@Service("TypeOfTripService")
public class TypeOfTripService implements ITypeOfTripService {
    @Autowired
    TypeOfTripRepository typeOfTripRepository;
    public TypeOfTrip save(TypeOfTrip typeOfTrip) {
        return typeOfTripRepository.save(typeOfTrip);
    }

    public TypeOfTrip get(long id) {
        return typeOfTripRepository.findOne(id);
    }

    public List<TypeOfTrip> getAll() {
        return typeOfTripRepository.findAll();
    }

    public void delete(TypeOfTrip typeOfTrip) {
        typeOfTripRepository.delete(typeOfTrip);
    }

    public void delete(long id) {
        typeOfTripRepository.delete(id);
    }
}
