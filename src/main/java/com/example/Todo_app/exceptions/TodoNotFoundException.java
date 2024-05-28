package com.example.Todo_app.exceptions;

public class TodoNotFoundException extends RuntimeException{
    public TodoNotFoundException(String todoNotFound, long id){
        super("Not found todo with this id " + id);
    }
}
