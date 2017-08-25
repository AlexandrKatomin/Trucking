package trucking.repository;

import trucking.entity.TypeOfTrip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Alex on 15.08.2017.
 */
@Repository
public interface TypeOfTripRepository extends JpaRepository<TypeOfTrip,Long> {
}
