package com.shkal.clothingstore.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerGlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<CustomerIncorrectData> handlerException(NoSuchCustomerException exception) {
        CustomerIncorrectData data = new CustomerIncorrectData();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<CustomerIncorrectData> handlerException(Exception exception) {
        CustomerIncorrectData data = new CustomerIncorrectData();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }
}
