package com.example.Todo_app.Controller;

import com.example.Todo_app.model.Todo;
import com.example.Todo_app.service.Service;
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
    public List<Todo> getTodos(){
        return service.getTodos();
    }

    @PostMapping("/todoNew")
    public String addTodo(@RequestBody Todo todoItems){
        service.addTodo(todoItems);
        return "added new todo";
    }

    @PostMapping("/todoDelete/{id}")
    public String delete(@PathVariable long id){
        service.delete(id);
        return "deleted todo";
    }

    @PostMapping("/todoUpdate/{id}")
    public String update(@PathVariable long id){
        return "updated";
    }

}
