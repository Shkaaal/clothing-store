package com.shkal.clothingstore.exception_handling;

public class NoSuchCustomerException extends RuntimeException{
    public NoSuchCustomerException(String message) {
        super(message);
    }
}
