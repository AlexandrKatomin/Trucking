package trucking.service;

import trucking.entity.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trucking.repository.ContractRepository;

import java.util.List;

/**
 * Created by Alex on 15.08.2017.
 */
@Service("ContractService")
public class ContractService implements IContractService {
    @Autowired
    ContractRepository contractRepository;

    public Contract save(Contract contract) {
        return contractRepository.saveAndFlush(contract);
    }

    public Contract get(long id) {

        return contractRepository.findOne(id);
    }

    public List<Contract> getAll() {
        return contractRepository.findAll();
    }

    public List<String> getAllContractWithoutTrip(){
        return contractRepository.getAllContractWithoutTrip();
    }

    public List<String> getAllNumbersOfContracts(){
        return contractRepository.getAllNumbersOfContracts();
    }

    public void delete(Contract contract) {
        contractRepository.delete(contract);
    }

    public void delete(long id) {
        contractRepository.delete(id);
    }

    public Contract findByNumberContract(String number){
        return contractRepository.findByNumberContract(number);
    }
}
