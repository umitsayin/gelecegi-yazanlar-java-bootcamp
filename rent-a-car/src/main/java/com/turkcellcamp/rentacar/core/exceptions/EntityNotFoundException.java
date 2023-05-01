package com.turkcellcamp.rentacar.core.exceptions;

public class EntityNotFoundException extends RuntimeException{
   public EntityNotFoundException(String message){
       super(message);
   }
}
