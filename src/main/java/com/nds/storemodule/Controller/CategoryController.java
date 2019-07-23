package com.nds.storemodule.Controller;

import com.nds.storemodule.Exception.ControllerAdvice.ResourceCanNotPersistException;
import com.nds.storemodule.Exception.ControllerAdvice.ResourceNotFoundException;
import com.nds.storemodule.Model.Category;
import com.nds.storemodule.Service.RepositoryService.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1.0/Categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/all",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Category>> fetchAll() throws ResourceNotFoundException {

        List<Category> categoryList;
        categoryList = categoryService.findAll();
        if (categoryList!=null) {
            return new ResponseEntity<>(categoryList, HttpStatus.OK);
        }else {
            throw new ResourceNotFoundException("داده ای برای نمایش وجود ندارد!");
        }

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> fetchById(@PathVariable Integer id) throws ResourceNotFoundException{
        Category category = categoryService.findById(id);
        if (category!=null){
            return new ResponseEntity<>(category,HttpStatus.OK);
        }else {
            throw new ResourceNotFoundException("دسته بندی بااین شناسه یافت نشد!");
        }
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Category> save(@RequestBody Category category) throws ResourceCanNotPersistException {
        int result = categoryService.add(category);
        if (result==1){
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            throw new ResourceCanNotPersistException("خطا در ثبت داده!");
        }
    }

    @PutMapping(value = "/edit",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Category> update(@RequestBody Category category) throws ResourceCanNotPersistException{
        int result = categoryService.update(category);
        if (result==1){
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            throw new ResourceCanNotPersistException("خطا در بروز رسانی داده!");
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Category> delete(@PathVariable Integer id) throws ResourceCanNotPersistException{
        int result = categoryService.delete(id);
        if (result==1){
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            throw new ResourceCanNotPersistException("خطا در حذف داده!");
        }
    }

}
