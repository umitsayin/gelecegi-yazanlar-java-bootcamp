package com.turkcell.ecommerce.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<?> businessExceptionHandler(BusinessException e, HttpServletRequest request){
        return ResponseEntity.ok(getExceptionResponse(e.getMessage(), request, HttpStatus.BAD_REQUEST));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> businessExceptionHandler(MethodArgumentNotValidException e, HttpServletRequest request){
        ValidationExceptionResponse response = new ValidationExceptionResponse(HttpStatus.BAD_REQUEST,
                        request.getServletPath(),
                        LocalDateTime.now(),
                        e.getObjectName(),
                        e.getBindingResult());

        return ResponseEntity.ok(response);
    }

    private ExceptionResponse getExceptionResponse(String message, HttpServletRequest request, HttpStatus status){
        return new ExceptionResponse(status, request.getServletPath(), LocalDateTime.now(), message);
    }
}
