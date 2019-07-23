package com.nds.storemodule.Service.RepositoryServiceImpl;

import com.nds.storemodule.Dao.Repository.GuaranteeRepository;
import com.nds.storemodule.Model.Guarantee;
import com.nds.storemodule.Service.RepositoryService.GuaranteeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GuaranteeServiceImpl implements GuaranteeService {

    @Autowired
    private GuaranteeRepository guaranteeRepository;

    @Override
    public List<Guarantee> findAll() {
        return guaranteeRepository.findAll();
    }

    @Override
    public Guarantee findById(Integer id) {
        return guaranteeRepository.findById(id);
    }

    @Override
    public int add(Guarantee guarantee) {
        return guaranteeRepository.add(guarantee);
    }

    @Override
    public int update(Guarantee guarantee) {
        return guaranteeRepository.update(guarantee);
    }

    @Override
    public int delete(Integer id) {
        return guaranteeRepository.delete(id);
    }
}
