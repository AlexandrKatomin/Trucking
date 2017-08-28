package trucking.service;

import trucking.entity.PaymantOfContract;

import java.util.List;

/**
 * Created by Alex on 15.08.2017.
 */
public interface IPaymantOfContractService {

    PaymantOfContract save(PaymantOfContract paymantOfContract);
    List<PaymantOfContract> getAll();
    PaymantOfContract get(long id);
    void delete(PaymantOfContract paymantOfContract);
    void delete(long id);

}



