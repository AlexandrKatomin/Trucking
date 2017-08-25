package trucking.service;

import trucking.entity.Driver;

import java.util.List;

/**
 * Created by Alex on 15.08.2017.
 */
public interface IDriverService extends IService  {

    Driver save(Driver driver);
    Driver get(Long id);
    List<Driver> getAll();
    void delete(Driver driver);
    void delete(long id);
}
