package com.turkcell.ecommerce.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Getter
public class ValidationExceptionResponse extends ExceptionResponse {
    private Map<String, String> errors;

    public ValidationExceptionResponse(HttpStatus status, String path,  LocalDateTime timestamp, String message,BindingResult bindingResult) {
        super(status, path, timestamp, message);
        errors = new HashMap<>();
        setErrors(bindingResult);
    }

    public void setErrors(BindingResult result){
        for(FieldError e : result.getFieldErrors()){
            errors.put(e.getField(), e.getDefaultMessage());
        }
    }
}