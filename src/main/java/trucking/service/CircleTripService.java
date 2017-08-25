package trucking.service;

import trucking.entity.CircleTrip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trucking.repository.CircleTripRepository;

import java.util.List;

/**
 * Created by Alex on 15.08.2017.
 */
@Service("CircleTripService")
public class CircleTripService {
    @Autowired
    CircleTripRepository circleTripRepository;
    public CircleTrip save(CircleTrip circleTrip) {
        return circleTripRepository.save(circleTrip);
    }

    public List<CircleTrip> getAll() {
        return circleTripRepository.findAll();
    }

    public CircleTrip get(long id) {
        return circleTripRepository.findOne(id);
    }

    public void delete(CircleTrip circleTrip) {
        circleTripRepository.delete(circleTrip);

    }

    public void delete(long id) {
        circleTripRepository.delete(id);
    }
}
