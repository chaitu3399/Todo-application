package com.example.Todo_app.service;

import com.example.Todo_app.dao.Repository;
import com.example.Todo_app.exceptions.TodoNotFoundException;
import com.example.Todo_app.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {

    private final Repository repository;

    @Autowired
    public Service(Repository repository) {
        this.repository = repository;
    }


    public ResponseEntity<List<Todo>> getTodos() {
        return ResponseEntity.ok(repository.findAll());
    }

    public ResponseEntity<String> addTodo(Todo todoItems) {
        repository.save(todoItems);
        return ResponseEntity.ok("Added Todo successfully");
    }

    public ResponseEntity<String> delete(long id) {
        Optional<Todo> todo = repository.findById(id);
        if (todo.isEmpty()){
            throw new TodoNotFoundException("Not found todo", id);
        }
        repository.deleteById(id);
        return ResponseEntity.ok("Deleted todo successfully");
    }

    public void update(long id) {
        Optional<Todo> todo = repository.findById(id);
        Todo todoClass = new Todo();
        if (todo.isPresent()){
            todoClass.setCompleted(!todoClass.isCompleted());
        }
        else {
            throw new TodoNotFoundException("todo not found", id);
        }
    }
}
