package com.nds.storemodule.Service.RepositoryService;


import com.nds.storemodule.Model.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    Product findById(Long id);

    int add(Product product);

    int update(Product product);

    int delete(Long id);


}
