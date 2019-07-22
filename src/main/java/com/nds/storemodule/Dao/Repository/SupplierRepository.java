package com.nds.storemodule.Dao.Repository;

import com.northwind.basemodule.Model.Supplier;

import java.util.List;

public interface SupplierRepository {

    List<Supplier> findAll();

    Supplier findById(Long id);

    int update(Supplier supplier);

    int add(Supplier supplier);

    int delete(Long id);
}
