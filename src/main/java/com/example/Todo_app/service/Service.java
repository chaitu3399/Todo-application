package com.example.Todo_app.service;

import com.example.Todo_app.dao.TodoRepository;
import com.example.Todo_app.dao.UserRepository;
import com.example.Todo_app.exceptions.TodoNotFoundException;
import com.example.Todo_app.model.Todo;
import com.example.Todo_app.model.User;
import com.example.Todo_app.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {

    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    @Autowired
    public Service(TodoRepository todoRepository, UserRepository userRepository) {
        this.todoRepository = todoRepository;
        this.userRepository = userRepository;
    }


    public ResponseEntity<List<Todo>> getTodos() {
        return ResponseEntity.ok(todoRepository.findAll());
    }

    public ResponseEntity<String> addTodo(Todo todoItems) {
        todoRepository.save(todoItems);
        return ResponseEntity.ok("Added Todo successfully");
    }

    public ResponseEntity<String> delete(long id) {
        Optional<Todo> todo = todoRepository.findById(id);
        if (todo.isEmpty()){
            throw new TodoNotFoundException("Not found todo", id);
        }
        todoRepository.deleteById(id);
        return ResponseEntity.ok("Deleted todo successfully");
    }

    public void update(long id) {
        Optional<Todo> todo = todoRepository.findById(id);
        Todo todoClass = new Todo();
        if (todo.isPresent()){
            todoClass.setCompleted(!todoClass.isCompleted());
        }
        else {
            throw new TodoNotFoundException("todo not found", id);
        }
    }

    public Response registerUser(User user) {
        Optional<User> email = Optional.ofNullable(userRepository.findByEmail(user.getEmail()));
        if(email.isEmpty()){
            userRepository.save(user);
            return new Response("Registration successful", HttpStatus.OK, ZonedDateTime.now());
        }
        return new Response("Email already exists", HttpStatus.NOT_FOUND, ZonedDateTime.now());
    }

    public Response validateLogin(User user) {
        User user1 = userRepository.findByEmail(user.getEmail());
        if(user1 == null)
            return new Response("User does not exist, please register", HttpStatus.NOT_FOUND, ZonedDateTime.now());
        else {
            String email = user1.getEmail();
            String password = user1.getPassword();
            if(user.getEmail().equals(email) || user.getPassword().equals(password)){
                return new Response("user login successful", HttpStatus.OK, ZonedDateTime.now());
            }
            return new Response("Email or Password is incorrect", HttpStatus.NOT_FOUND, ZonedDateTime.now());
        }
    }
}
