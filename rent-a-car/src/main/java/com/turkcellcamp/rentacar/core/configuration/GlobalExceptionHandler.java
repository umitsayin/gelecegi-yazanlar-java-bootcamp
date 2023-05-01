package com.turkcellcamp.rentacar.core.configuration;

import com.turkcellcamp.rentacar.common.constants.Messages;
import com.turkcellcamp.rentacar.core.exceptions.BusinessException;
import com.turkcellcamp.rentacar.core.exceptions.EntityAlreadyExistsException;
import com.turkcellcamp.rentacar.core.exceptions.EntityNotFoundException;
import com.turkcellcamp.rentacar.core.utils.ExceptionResult;
import com.turkcellcamp.rentacar.core.utils.ValidExceptionResult;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResult entityNotFoundExceptionHandler(EntityNotFoundException e, HttpServletRequest request){
        return getExceptionResponse(e, request,HttpStatus.NOT_FOUND.toString());
    }

    @ExceptionHandler(EntityAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResult entityAlreadyExistsExceptionHandler(EntityAlreadyExistsException e, HttpServletRequest request){
        return getExceptionResponse(e, request,HttpStatus.ALREADY_REPORTED.toString());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ExceptionResult validExceptionHandler(MethodArgumentNotValidException e, HttpServletRequest request){
        ValidExceptionResult result = new ValidExceptionResult(HttpStatus.BAD_REQUEST.toString(),
                Messages.VALIDATION_EXCEPTION_MESSAGE,
                request.getServletPath(),
                LocalDateTime.now());

        result.setErrors(e.getBindingResult());

        return result;
    }

    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResult entityNotFoundExceptionHandler(BusinessException e, HttpServletRequest request){
        return getExceptionResponse(e, request,HttpStatus.NOT_FOUND.toString());
    }

    private ExceptionResult getExceptionResponse(RuntimeException e,
                                                 HttpServletRequest request,
                                                 String status){
        return new ExceptionResult(status,e.getMessage(),request.getServletPath(),LocalDateTime.now());
    }
}
