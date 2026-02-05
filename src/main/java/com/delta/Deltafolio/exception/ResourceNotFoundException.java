package com.delta.Deltafolio.exception;

public class ResourceNotFoundException extends RuntimeException {
<<<<<<< HEAD
    
    public ResourceNotFoundException(String message) {
        super(message);
    }
    
=======

    public ResourceNotFoundException(String message) {
        super(message);
    }

>>>>>>> f96157996631531800a5a9e14c505ea991a31203
    public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
    }
}

