package trucking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trucking.entity.PaymantOfContract;
import trucking.repository.PaymantOfContractRepository;

import java.util.List;

/**
 * Created by Alex on 27.08.2017.
 */
@Service("PaymantOfContractService")
public class PaymantOfContractService implements IPaymantOfContractService {
    @Autowired
    PaymantOfContractRepository paymantOfContractRepository;

    @Override
    public PaymantOfContract save(PaymantOfContract paymantOfContract) {
        return paymantOfContractRepository.save(paymantOfContract);
    }

    @Override
    public List<PaymantOfContract> getAll() {
        return paymantOfContractRepository.findAll();
    }

    @Override
    public PaymantOfContract get(long id) {
        return paymantOfContractRepository.findOne(id);
    }

    @Override
    public void delete(PaymantOfContract paymantOfContract) {
         paymantOfContractRepository.delete(paymantOfContract);
    }

    @Override
    public void delete(long id) {
        paymantOfContractRepository.delete(id);
    }


}
