package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

public interface UserService {
    User create(User user);

    User update(User user, long userId);

    List<User> getAll();

    User getById(Long userId);

    void delete(Long userId);

}
