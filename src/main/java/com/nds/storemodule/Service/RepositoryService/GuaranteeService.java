package com.nds.storemodule.Service.RepositoryService;

import com.nds.storemodule.Model.Guarantee;
import com.nds.storemodule.Model.Product;

import java.util.List;

public interface GuaranteeService {

    List<Guarantee> findAll();

    Guarantee findById(Integer id);

    int add(Guarantee guarantee);

    int update(Guarantee guarantee);

    int delete(Integer id);

}
