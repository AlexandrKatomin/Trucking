package trucking.service;

import trucking.entity.Trip;

import java.util.List;

/**
 * Created by Alex on 15.08.2017.
 */
public interface ITripService {
    Trip save(Trip trip);
    Trip get(long id);
    List<Trip> getAll();
    void delete(Trip trip);
    void delete(long id);

}
