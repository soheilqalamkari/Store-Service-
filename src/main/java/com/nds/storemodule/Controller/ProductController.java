package com.nds.storemodule.Controller;

import com.northwind.basemodule.Exception.ResourceNotFoundException;
import com.northwind.basemodule.Model.Product;
import com.northwind.basemodule.Service.RepositoryService.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/Products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/all",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> getAll() throws ResourceNotFoundException{

        List<Product> productList;
        productList = productService.findAll();
        if (productList!=null) {
            return new ResponseEntity<>(productList, HttpStatus.OK);
        }else {
            throw new ResourceNotFoundException("داده ای برای نمایش وجود ندارد!");
        }

    }





    @PostMapping(value = "/add",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> save(@RequestBody Product product){

        int result = productService.add(product);
        if (result==1){
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }

    }

}
