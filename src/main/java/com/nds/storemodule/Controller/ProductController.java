package com.nds.storemodule.Controller;

import com.nds.storemodule.Exception.ControllerAdvice.ResourceCanNotPersistException;
import com.nds.storemodule.Exception.ControllerAdvice.ResourceNotFoundException;
import com.nds.storemodule.Model.Product;
import com.nds.storemodule.Service.RepositoryService.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/v1.0/Products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/all",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> fetchAll() throws ResourceNotFoundException {

        List<Product> productList;
        productList = productService.findAll();
        if (productList!=null) {
            return new ResponseEntity<>(productList, HttpStatus.OK);
        }else {
            throw new ResourceNotFoundException("داده ای برای نمایش وجود ندارد!");
        }

    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> fetchById(@PathVariable Long id) throws ResourceNotFoundException{
        Product product = productService.findById(id);
        if (product!=null){
            return new ResponseEntity<>(product,HttpStatus.OK);
        }else {
            throw new ResourceNotFoundException("محصولی با این شناسه یافت نشد!");
        }
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Product> save(@RequestBody Product product) throws ResourceCanNotPersistException {
        int result = productService.add(product);
        if (result==1){
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            throw new ResourceCanNotPersistException("خطا در ثبت داده!");
        }
    }

    @PutMapping(value = "/edit",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> update(@RequestBody Product product) throws ResourceCanNotPersistException{

        int result = productService.update(product);
        if (result==1){
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            throw new ResourceCanNotPersistException("خطا در بروز رسانی داده!");
        }
    }


    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Product> delete(@PathVariable Long id) throws ResourceCanNotPersistException{
        int result = productService.delete(id);
        if (result==1){
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            throw new ResourceCanNotPersistException("خطا در حذف داده!");
        }
    }

}
