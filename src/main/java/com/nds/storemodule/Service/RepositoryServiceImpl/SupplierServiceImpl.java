package com.nds.storemodule.Service.RepositoryServiceImpl;

import com.nds.storemodule.Model.Supplier;
import com.nds.storemodule.Service.RepositoryService.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierService supplierService;

    @Override
    public List<Supplier> findAll() {
        return supplierService.findAll();
    }

    @Override
    public Supplier findById(Long id) {
        return supplierService.findById(id);
    }

    @Override
    public int update(Supplier supplier) {
        return supplierService.update(supplier);
    }

    @Override
    public int add(Supplier supplier) {
        return supplierService.add(supplier);
    }

    @Override
    public int delete(Long id) {
        return supplierService.delete(id);
    }
}
