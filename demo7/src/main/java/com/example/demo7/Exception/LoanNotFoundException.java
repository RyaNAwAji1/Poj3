package com.example.demo7.Exception;

public class LoanNotFoundException extends RuntimeException {
    public LoanNotFoundException(String message){
        super(message);
    }
}
