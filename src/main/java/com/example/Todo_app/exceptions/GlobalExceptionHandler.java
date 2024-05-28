package com.example.Todo_app.exceptions;

import com.example.Todo_app.response.Response;
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
        Response response = new Response(
                todoNotFoundException.getMessage(),
                HttpStatus.NO_CONTENT,
                ZonedDateTime.now()
        );
        //return the response entity
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
