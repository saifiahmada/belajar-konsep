package com.saifiahmada.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionController {
	
    @ResponseStatus(value=HttpStatus.NOT_FOUND, reason="IOException occured")
    @ExceptionHandler(Exception.class)
    public String handleIOException(){
        return "error";
    }

}
