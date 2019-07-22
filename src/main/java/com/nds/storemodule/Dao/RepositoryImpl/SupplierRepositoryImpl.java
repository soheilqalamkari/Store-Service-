package com.nds.storemodule.Dao.RepositoryImpl;


import com.nds.storemodule.Dao.Repository.SupplierRepository;
import com.nds.storemodule.Model.Supplier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class SupplierRepositoryImpl implements SupplierRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Supplier> findAll() {
        try {
            List<Supplier> supplierList = new ArrayList<>();
            supplierList=entityManager.createQuery("select s from Supplier s",Supplier.class)
                    .getResultList();
            return supplierList;
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public Supplier findById(Long id) {
        try {
            Supplier supplier = entityManager.find(Supplier.class,id);
            return supplier;
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public int update(Supplier supplier) {
        try {
            Supplier supplierObj = findById(supplier.getSupplierId());
            supplierObj.setAddress(supplier.getAddress());
            supplierObj.setCity(supplier.getCity());
            supplierObj.setCompanyEmail(supplier.getCompanyEmail());
            supplierObj.setCompanyName(supplier.getContactName());
            supplierObj.setContactName(supplier.getContactName());
            supplierObj.setCountry(supplier.getCountry());
            supplierObj.setContactTitle(supplier.getContactTitle());
            supplierObj.setHomePage(supplier.getHomePage());
            supplierObj.setPhone(supplier.getPhone());
            supplierObj.setPostalCode(supplier.getPostalCode());
            return 1;
        }catch (Exception e){
            return 0;
        }
    }

    @Override
    public int add(Supplier supplier) {
        try {
            entityManager.persist(supplier);
            return 1;
        }catch (Exception e){
            return 0;
        }
    }

    @Override
    public int delete(Long id) {
        try {
            entityManager.remove(findById(id));
            return 1;
        }catch (NoResultException e){
            return 0;
        }
    }
}
