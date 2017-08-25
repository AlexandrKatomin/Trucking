package trucking.service;

import trucking.entity.Company;

import java.util.List;

/**
 * Created by Alex on 15.08.2017.
 */
public interface ICompanyService extends IService  {
    Company save(Company company);
    Company get(long id);
    List<Company> getAll();
    void delete(Company company);
    void delete(long id);
}
