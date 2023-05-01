package com.turkcellcamp.rentacar.core.exceptions;

public class EntityAlreadyExistsException extends RuntimeException{
    public EntityAlreadyExistsException(String message){
        super(message);
    }
}
