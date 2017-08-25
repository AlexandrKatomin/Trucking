package trucking.service;

import trucking.entity.CircleTrip;

import java.util.List;

/**
 * Created by Alex on 15.08.2017.
 */
public interface ICircleTripService extends IService  {

    CircleTrip save(CircleTrip circleTrip);
    List<CircleTrip> getAll();
    CircleTrip get(long id);
    void delete(CircleTrip circleTrip);
    void delete (long id);
}
