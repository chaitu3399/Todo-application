package com.example.Todo_app.Controller;

import com.example.Todo_app.model.Todo;
import com.example.Todo_app.model.User;
import com.example.Todo_app.response.Response;
import com.example.Todo_app.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class Controller {

    private final Service service;

    @Autowired
    public Controller(Service service) {
        this.service = service;
    }

    @GetMapping("/gettodos")
    public ResponseEntity<List<Todo>> getTodos(){
        return service.getTodos();
    }

    @PostMapping("/todoNew")
    public Response addTodo(@RequestBody Todo todoItems){
        return service.addTodo(todoItems);
    }

    @PostMapping("/todoDelete/{id}")
    public Object delete(@PathVariable long id){
        return service.delete(id);
    }

    @PostMapping("/todoUpdate/{id}")
    public Object update(@PathVariable long id){
        return service.update(id);
    }

    @PostMapping("/register")
    public Response register(@RequestBody User user){
        return service.registerUser(user);
    }

    @GetMapping("/login")
    public Response login(@RequestBody User user){
        return service.validateLogin(user);
    }

}
