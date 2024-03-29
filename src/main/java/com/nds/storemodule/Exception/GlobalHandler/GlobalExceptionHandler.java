package com.nds.storemodule.Exception.GlobalHandler;


import com.nds.storemodule.Exception.ControllerAdvice.ResourceCanNotPersistException;
import com.nds.storemodule.Exception.ControllerAdvice.ResourceNotFoundException;
import com.nds.storemodule.Exception.ErrorFormat.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(ex.getMessage(),new Date(),webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globalInternalServerException(Exception ex,WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(ex.getMessage(),new Date(),webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceCanNotPersistException.class)
    public ResponseEntity<?> resourceCanNotPersist(ResourceCanNotPersistException ex, WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(ex.getMessage(),new Date(),webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails,HttpStatus.EXPECTATION_FAILED);
    }
}
