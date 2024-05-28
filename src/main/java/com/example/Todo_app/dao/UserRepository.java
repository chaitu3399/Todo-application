package com.example.Todo_app.dao;

import com.example.Todo_app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByEmail(String email);
    public User findByPassword(String password);
}
