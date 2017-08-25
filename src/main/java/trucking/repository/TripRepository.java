package trucking.repository;

import org.springframework.data.jpa.repository.Query;
import trucking.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Alex on 15.08.2017.
 */
@Repository
public interface TripRepository extends JpaRepository<Trip,Long> {



  //  Car findByModel(String model);
}
