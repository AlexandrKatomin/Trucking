package trucking.repository;

import trucking.entity.PaymantOfContract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Alex on 15.08.2017.
 */
@Repository
public interface PaymantOfContractRepository extends JpaRepository<PaymantOfContract,Long> {
}
