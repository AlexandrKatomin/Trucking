package trucking.repository;

import org.springframework.data.jpa.repository.Query;
import trucking.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

/**
 * Created by Alex on 15.08.2017.
 */
@Repository
public interface CarRepository extends JpaRepository<Car,Long> {
    @Query(value = "SELECT model from Car", nativeQuery = true)
    List<String > getAllModel();

    Car findByModel(String model);
}
