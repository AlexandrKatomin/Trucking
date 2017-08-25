package trucking.service;

import trucking.entity.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trucking.repository.DriverRepository;

import java.util.List;

/**
 * Created by Alex on 15.08.2017.
 */
@Service("DriverService")
public class DriverService implements IDriverService {
    @Autowired
    DriverRepository driverRepository;
    public Driver save(Driver driver) {
        return driverRepository.save(driver);
    }

    public Driver get(Long id) {
        return driverRepository.findOne(id);
    }

    public List<Driver> getAll() {
        return driverRepository.findAll();
    }

    public void delete(Driver driver) {
        driverRepository.delete(driver);
    }

    public void delete(long id) {
        driverRepository.delete(id);
    }

    public List<String> getAllLastName(){
        return driverRepository.getAllLastName();
    }

    public Driver findByLastName(String lastNeme){
        return driverRepository.findByLastName(lastNeme);
    }

}
