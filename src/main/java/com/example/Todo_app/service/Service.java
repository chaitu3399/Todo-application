package com.example.Todo_app.service;

import com.example.Todo_app.dao.Repository;
import com.example.Todo_app.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    public void addTodo(Todo todoItems) {
        repository.save(todoItems);
    }

    public void delete(long id) {
        repository.deleteById(id);
    }

    public void update(long id) {
        Optional<Todo> todo = repository.findById(id);
        Todo todoClass = new Todo();
        if (todo.isPresent() && todoClass.isCompleted()){
            todoClass.setCompleted(false);
        }
        else {
            todoClass.setCompleted(true);
        }
    }
}
