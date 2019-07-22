package com.nds.storemodule.Exception.ControllerAdvice;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.EXPECTATION_FAILED)
public class ResourceCanNotPersistException extends Exception {

    public ResourceCanNotPersistException(String message) {
        super(message);
    }
}
