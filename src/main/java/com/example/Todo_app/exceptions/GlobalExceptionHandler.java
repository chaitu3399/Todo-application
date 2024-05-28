package com.example.Todo_app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {TodoNotFoundException.class})
    public ResponseEntity<Object> todoNotFoundException(TodoNotFoundException todoNotFoundException ){
        //creating payload containing exception details
        TodoException todoException = new TodoException(
                todoNotFoundException.getMessage(),
                HttpStatus.NO_CONTENT,
                ZonedDateTime.now()
        );
        //return the response entity
        return new ResponseEntity<>(todoException, HttpStatus.NOT_FOUND);
    }

}
