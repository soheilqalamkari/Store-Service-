package com.nds.storemodule.Service.RepositoryServiceImpl;

import com.nds.storemodule.Dao.Repository.ProductRepository;
import com.nds.storemodule.Model.Product;
import com.nds.storemodule.Service.RepositoryService.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public int add(Product product) {
        return productRepository.add(product);
    }

    @Override
    public int update(Product product) {
        return productRepository.update(product);
    }

    @Override
    public int delete(Long id) {
        return productRepository.delete(id);
    }
}
