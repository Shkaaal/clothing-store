package com.shkal.clothingstore.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<CustomerIncorrectData> handlerException(NoSuchCustomerException exception) {
        CustomerIncorrectData data = new CustomerIncorrectData();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoSuchOrderException.class)
    public ResponseEntity<OrderIncorrectData> handlerException(NoSuchOrderException exception) {
        OrderIncorrectData data = new OrderIncorrectData();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoSuchProductException.class)
    public ResponseEntity<ProductIncorrectData> handlerException(NoSuchProductException exception) {
        ProductIncorrectData data = new ProductIncorrectData();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

//    @ExceptionHandler
//    public ResponseEntity<CustomerIncorrectData> handlerExceptionForCustomer(Exception exception) {
//        CustomerIncorrectData data = new CustomerIncorrectData();
//        data.setInfo(exception.getMessage());
//
//        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
//    }
//
//    @ExceptionHandler
//    public ResponseEntity<OrderIncorrectData> handlerExceptionForOrder(Exception exception) {
//        OrderIncorrectData data = new OrderIncorrectData();
//        data.setInfo(exception.getMessage());
//
//        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
//    }
}
