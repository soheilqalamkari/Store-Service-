package com.nds.storemodule.Dao.RepositoryImpl;


import com.nds.storemodule.Dao.Repository.CategoryRepository;
import com.nds.storemodule.Dao.Repository.GuaranteeRepository;
import com.nds.storemodule.Dao.Repository.ProductRepository;
import com.nds.storemodule.Dao.Repository.SupplierRepository;
import com.nds.storemodule.Model.Category;
import com.nds.storemodule.Model.Guarantee;
import com.nds.storemodule.Model.Product;
import com.nds.storemodule.Model.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class ProductRepositoryImpl implements ProductRepository {


    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private SupplierRepository supplierRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private GuaranteeRepository guaranteeRepository;


    @Override
    public List<Product> findAll() {
        try {
            List<Product> productList = new ArrayList<>();
            productList=entityManager.createQuery("select p from Product p",Product.class)
                    .getResultList();
            return productList;
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public Product findById(Long id) {
        try {
            Product product = entityManager.find(Product.class,id);
            return product;
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public int update(Product product) {
        try {
            Product productObj = findById(product.getProductId());
            Category category = categoryRepository.findById(product.getCategoryId());
            Supplier supplier = supplierRepository.findById(product.getSupplierId());
            Guarantee guarantee = guaranteeRepository.findById(product.getGuaranteeId());
            productObj.setProductName(product.getProductName());
            productObj.setDiscontinued(product.getDiscontinued());
            productObj.setQuantityPerUnit(product.getQuantityPerUnit());
            productObj.setReorderLevel(product.getReorderLevel());
            productObj.setUnitsInStock(product.getUnitsInStock());
            productObj.setUnitsOnOrder(product.getUnitsOnOrder());
            productObj.setCategory(category);
            productObj.setSupplier(supplier);
            productObj.setGuarantee(guarantee);
            entityManager.merge(productObj);
            return 1;
        }catch (Exception e){
            return 0;
        }
    }

    @Override
    public int add(Product product) {
        try {
            entityManager.persist(product);
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
