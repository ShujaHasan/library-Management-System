package com.shuja.library_management.exception;

public class MethodArgumentNotValidException extends RuntimeException {
    public MethodArgumentNotValidException(String message){
        super(message);
    }
}
