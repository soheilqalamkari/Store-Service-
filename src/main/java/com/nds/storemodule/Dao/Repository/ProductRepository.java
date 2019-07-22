package com.nds.storemodule.Dao.Repository;

import com.northwind.basemodule.Model.Product;

import java.util.List;


public interface ProductRepository{

   List<Product> findAll();

   Product findById(Long id);

   int update(Product product);

   int add(Product product);

   int delete(Long id);

}
