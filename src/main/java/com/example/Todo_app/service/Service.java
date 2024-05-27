package com.example.Todo_app.service;

import com.example.Todo_app.dao.Repository;
import com.example.Todo_app.model.Todo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {

    private final Repository repository;

    public Service(Repository repository) {
        this.repository = repository;
    }


    public List<Todo> getTodos() {
        return repository.findAll();
    }

    public void addTodo(Todo todoItems) {
        repository.save(todoItems);
    }

    public void delete(long id) {
        repository.deleteById(id);
    }

}
