package com.example.demo7.Advice;

import com.example.demo7.Exception.BookNotFoundException;
import com.example.demo7.Exception.InvalidException;
import com.example.demo7.Exception.LoanNotFoundException;
import com.example.demo7.Exception.UserNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {
    Logger logger = LoggerFactory.getLogger(ControllerAdvice.class);

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity handleMethodArgument(MethodArgumentNotValidException methodArgumentNVE) {
        logger.warn("MethodArgumentNotValidException");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(methodArgumentNVE.getFieldError().getDefaultMessage());
    }

    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ResponseEntity handleDataIntegrity(DataIntegrityViolationException dataIntegrityVE) {
        logger.warn("DataIntegrityViolationException");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body((dataIntegrityVE.getCause().getMessage()));
    }

    @ExceptionHandler(value = InvalidException.class)
    public ResponseEntity handleDataIntegrity(InvalidException invalidIDE) {
        logger.warn("InvalidException");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(invalidIDE.getCause().getMessage());
    }

    @ExceptionHandler(value = BookNotFoundException.class)
    public ResponseEntity handleDataIntegrity(BookNotFoundException bankNotFoundException) {
        logger.warn("BookNotFoundException");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bankNotFoundException.getCause().getMessage());
    }

    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity handleDataIntegrity(UserNotFoundException customerDetailsNotFoundException) {
        logger.warn("UserNotFoundException");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(customerDetailsNotFoundException.getCause().getMessage());
    }

    @ExceptionHandler(value = LoanNotFoundException.class)
    public ResponseEntity handleDataIntegrity(LoanNotFoundException customersNotFoundException) {
        logger.warn("LoanNotFoundException");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(customersNotFoundException.getCause().getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity handleException(Exception exception) {
        logger.error("Exception");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getCause().getMessage());


    }
}




