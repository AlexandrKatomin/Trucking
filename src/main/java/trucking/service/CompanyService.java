package trucking.service;

import trucking.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trucking.repository.CompanyRepository;

import java.util.List;

/**
 * Created by Alex on 15.08.2017.
 */
@Service("CompanyService")
public class CompanyService implements ICompanyService {
    @Autowired
    CompanyRepository companyRepository;
    public Company save(Company company) {
        return companyRepository.save(company);
    }

    public Company get(long id) {
        return companyRepository.findOne(id);
    }

    public List<Company> getAll() {
        return companyRepository.findAll();
    }

    public void delete(Company company) {
        companyRepository.delete(company);
    }

    public void delete(long id) {
        companyRepository.delete(id);
    }
}
