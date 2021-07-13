package com.store.apiusers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(CryptoStoreException.class)
    public ResponseEntity<StandardError> cryptoStoreException(CryptoStoreException e, HttpServletRequest request) {

        StandardError err = new StandardError(e.getStatus(), e.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(e.getStatus().value()).body(err);
    }
}
