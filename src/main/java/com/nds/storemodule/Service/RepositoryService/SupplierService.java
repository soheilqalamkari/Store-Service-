package com.nds.storemodule.Service.RepositoryService;

import com.nds.storemodule.Model.Guarantee;
import com.nds.storemodule.Model.Supplier;

import java.util.List;

public interface SupplierService {

    List<Supplier> findAll();

    Supplier findById(Long id);

    int update(Supplier supplier);

    int add(Supplier supplier);

    int delete(Long id);
}
