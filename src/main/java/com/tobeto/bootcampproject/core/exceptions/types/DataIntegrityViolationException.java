package com.tobeto.bootcampproject.core.exceptions.types;

public class DataIntegrityViolationException extends RuntimeException{
    public DataIntegrityViolationException(String message) {
        super(message);
    }

}
