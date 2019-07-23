package com.nds.storemodule.Controller;

import com.nds.storemodule.Exception.ControllerAdvice.ResourceCanNotPersistException;
import com.nds.storemodule.Exception.ControllerAdvice.ResourceNotFoundException;
import com.nds.storemodule.Model.Supplier;
import com.nds.storemodule.Service.RepositoryService.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1.0/Suppliers")
public class SupplierController {


    @Autowired
    private SupplierService supplierService;

    @GetMapping(value = "/all",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Supplier>> fetchAll() throws ResourceNotFoundException {

        List<Supplier> supplierList;
        supplierList = supplierService.findAll();
        if (supplierList!=null) {
            return new ResponseEntity<>(supplierList, HttpStatus.OK);
        }else {
            throw new ResourceNotFoundException("داده ای برای نمایش وجود ندارد!");
        }

    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<Supplier> fetchById(@PathVariable Long id) throws ResourceNotFoundException{
        Supplier supplier = supplierService.findById(id);
        if (supplier!=null){
            return new ResponseEntity<>(supplier,HttpStatus.OK);
        }else {
            throw new ResourceNotFoundException("تامین کننده ای بااین شناسه یافت نشد!");
        }
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Supplier> save(@RequestBody Supplier supplier) throws ResourceCanNotPersistException {
        int result = supplierService.add(supplier);
        if (result==1){
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            throw new ResourceCanNotPersistException("خطا در ثبت داده!");
        }
    }

    @PutMapping(value = "/edit",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Supplier> update(@RequestBody Supplier supplier) throws ResourceCanNotPersistException{
        int result = supplierService.update(supplier);
        if (result==1){
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            throw new ResourceCanNotPersistException("خطا در بروز رسانی داده!");
        }
    }


    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Supplier> delete(@PathVariable Long id) throws ResourceCanNotPersistException{
        int result = supplierService.delete(id);
        if (result==1){
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            throw new ResourceCanNotPersistException("خطا در حذف داده!");
        }
    }


}
