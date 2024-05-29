package com.example.Todo_app.dao;

import com.example.Todo_app.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    @Transactional
    @Modifying
    @Query("update Todo todo set todo.completed = ?1 where todo.id = ?2")
    void updateCompleted(boolean completed, Long id);
}
