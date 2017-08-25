package trucking.service;

import trucking.entity.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trucking.repository.TripRepository;

import java.util.List;

/**
 * Created by Alex on 15.08.2017.
 */
@Service("TripService")
public class TripService implements ITripService {
    @Autowired
    TripRepository tripRepository;
    public Trip save(Trip trip) {
        return tripRepository.save(trip);
    }

    public Trip get(long id) {
        return tripRepository.findOne(id);
    }

    public List<Trip> getAll() {
        return tripRepository.findAll();
    }

    public void delete(Trip trip) {
        tripRepository.delete(trip);
    }

    public void delete(long id) {
        tripRepository.delete(id);
    }


}
