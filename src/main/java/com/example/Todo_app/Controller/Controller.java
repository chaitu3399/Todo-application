package com.example.Todo_app.Controller;

import com.example.Todo_app.model.Todo;
import com.example.Todo_app.service.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class Controller {

    private Service service;

    public Controller(Service service) {
        this.service = service;
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Todo>> getTodos(){
        return service.getTodos();
    }

    @PostMapping("/todoNew")
    public ResponseEntity<String> addTodo(@RequestBody Todo todoItems){
        service.addTodo(todoItems);
        return ResponseEntity.ok("added new todo");
    }

    @PostMapping("/todoDelete/{id}")
    public ResponseEntity<String> delete(@PathVariable long id){
        service.delete(id);
        return ResponseEntity.ok("deleted todo");
    }

    @PostMapping("/todoUpdate/{id}")
    public ResponseEntity<String> update(@PathVariable long id){
        service.update(id);
        return ResponseEntity.ok("updated todo");
    }

}
