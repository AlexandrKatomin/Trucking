package trucking.service;

import trucking.entity.Car;

import java.util.List;

/**
 * Created by Alex on 15.08.2017.
 */
public interface ICarService extends IService {

    Car save(Car car);
    Car get(long id);
    List<Car> getAll();
    void delete(Car car);
    void delete(long id);
}
