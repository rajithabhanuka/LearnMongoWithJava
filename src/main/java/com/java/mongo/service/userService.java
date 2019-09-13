package com.java.mongo.service;

import com.java.mongo.model.Users;

import java.util.List;

public interface userService {
    Users save(Users users);
    boolean update(Users users);
    boolean remove(String id);
    List<Users> search();
}
