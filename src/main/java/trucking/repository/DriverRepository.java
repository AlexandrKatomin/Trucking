package trucking.repository;

import org.springframework.data.jpa.repository.Query;
import trucking.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Alex on 15.08.2017.
 */
@Repository
public interface DriverRepository extends JpaRepository<Driver,Long> {

    @Query(value = "SELECT lastName from Driver", nativeQuery = true)
    List<String > getAllLastName();

    Driver findByLastName(String lastName);
}
