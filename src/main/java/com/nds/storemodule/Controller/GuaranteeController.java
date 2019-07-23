package com.nds.storemodule.Controller;

import com.nds.storemodule.Exception.ControllerAdvice.ResourceCanNotPersistException;
import com.nds.storemodule.Exception.ControllerAdvice.ResourceNotFoundException;
import com.nds.storemodule.Model.Guarantee;
import com.nds.storemodule.Model.Product;
import com.nds.storemodule.Service.RepositoryService.GuaranteeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1.0/Guarantees")
public class GuaranteeController {

    @Autowired
    private GuaranteeService guaranteeService;


    @GetMapping(value = "/all",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Guarantee>> fetchAll() throws ResourceNotFoundException {

        List<Guarantee> guaranteeList;
        guaranteeList = guaranteeService.findAll();
        if (guaranteeList!=null) {
            return new ResponseEntity<>(guaranteeList, HttpStatus.OK);
        }else {
            throw new ResourceNotFoundException("داده ای برای نمایش وجود ندارد!");
        }

    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<Guarantee> fetchById(@PathVariable Integer id) throws ResourceNotFoundException{
        Guarantee guarantee = guaranteeService.findById(id);
        if (guarantee!=null){
            return new ResponseEntity<>(guarantee,HttpStatus.OK);
        }else {
            throw new ResourceNotFoundException("محصولی با این شناسه یافت نشد!");
        }
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Guarantee> save(@RequestBody Guarantee guarantee) throws ResourceCanNotPersistException {
        int result = guaranteeService.add(guarantee);
        if (result==1){
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            throw new ResourceCanNotPersistException("خطا در ثبت داده!");
        }
    }

    @PutMapping(value = "/edit",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Guarantee> update(@RequestBody Guarantee guarantee) throws ResourceCanNotPersistException{

        int result = guaranteeService.update(guarantee);
        if (result==1){
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            throw new ResourceCanNotPersistException("خطا در بروز رسانی داده!");
        }
    }


    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Guarantee> delete(@PathVariable Integer id) throws ResourceCanNotPersistException{
        int result = guaranteeService.delete(id);
        if (result==1){
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            throw new ResourceCanNotPersistException("خطا در حذف داده!");
        }
    }
}
