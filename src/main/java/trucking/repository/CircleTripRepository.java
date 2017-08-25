package trucking.repository;

import trucking.entity.CircleTrip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Alex on 15.08.2017.
 */
@Repository
public interface CircleTripRepository extends JpaRepository<CircleTrip,Long> {
}
