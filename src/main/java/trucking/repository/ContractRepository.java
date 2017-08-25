package trucking.repository;

import org.springframework.data.jpa.repository.Query;
import trucking.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Alex on 15.08.2017.
 */
@Repository
public interface ContractRepository extends JpaRepository<Contract,Long> {

    @Query(value = "SELECT contract.numberContract \n" +
            "From Contract LEFT JOIN Trip\n" +
            "ON Contract.id != Trip.id_contract ", nativeQuery = true)
    List<String > getAllContractWithoutTrip();

    Contract findByNumberContract(String number);
}
