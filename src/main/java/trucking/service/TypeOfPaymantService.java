package trucking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trucking.entity.TypeOfPaymant;
import trucking.repository.TypeOfPaymantRepository;

import java.util.List;

/**
 * Created by Alex on 28.08.2017.
 */
@Service("TypeOfPaymantService")
public class TypeOfPaymantService implements ITypeOfPaymantService{

    @Autowired
    TypeOfPaymantRepository typeOfPaymantRepository;

    @Override
    public TypeOfPaymant save(TypeOfPaymant typeOfPaymant) {
        return typeOfPaymantRepository.save(typeOfPaymant);
    }

    @Override
    public List<TypeOfPaymant> getAll() {
        return typeOfPaymantRepository.findAll();
    }

    @Override
    public void delete(TypeOfPaymant typeOfPaymant) {
        typeOfPaymantRepository.delete(typeOfPaymant);
    }

    @Override
    public void delete(long id) {
        typeOfPaymantRepository.delete(id);
    }
}
