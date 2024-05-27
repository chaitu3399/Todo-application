package com.example.Todo_app.dao;

import com.example.Todo_app.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Todo, Long> {
}
