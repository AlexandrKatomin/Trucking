package trucking.service;

import trucking.entity.Contract;

import java.util.List;

/**
 * Created by Alex on 15.08.2017.
 */
public interface IContractService extends IService  {
    Contract save(Contract contract);
    Contract get(long id);
    List<Contract> getAll();
    void delete(Contract contract);
    void delete (long id);
}
