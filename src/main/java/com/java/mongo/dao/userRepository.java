package com.java.mongo.dao;

import com.java.mongo.model.Users;

import java.util.List;

public interface userRepository {
    Users save(Users users);
    boolean update(Users users);
    boolean remove(String id);
    List<Users> search();
}
