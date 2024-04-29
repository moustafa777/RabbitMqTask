package com.example.rabbitqtask.exceptionHandler;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler  {

    @ExceptionHandler(Exception.class)
    public String handleJmsException(Exception e) {
        return "Exception occurred: " + e.getMessage();
    }

}
