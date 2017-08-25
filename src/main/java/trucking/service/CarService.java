package trucking.service;

import trucking.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trucking.repository.CarRepository;

import java.util.List;

/**
 * Created by Alex on 15.08.2017.
 */
@Service("CarService")
public class CarService {
    @Autowired
    CarRepository carRepository;
    public Car save(Car car) {
        return carRepository.save(car);
    }

    public Car get(long id) {
        return carRepository.findOne(id);
    }

    public List<Car> getAll() {
        return carRepository.findAll();
    }

    public void delete(Car car) {
        carRepository.delete(car);
    }

    public void delete(long id) {
        carRepository.delete(id);
    }

    public List<String > getAllModel(){ return carRepository.getAllModel();}

    public Car getByModel(String model){ return  carRepository.findByModel(model);}

}
