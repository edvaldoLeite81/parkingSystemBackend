package com.okavango.exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(long id, String message){
        super(message);
    }
}
