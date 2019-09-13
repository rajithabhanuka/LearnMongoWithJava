package com.java.mongo.service;

import com.java.mongo.dao.userRepository;
import com.java.mongo.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class userServiceImpl implements userService {

    @Autowired
    private userRepository userRepository;

    @Override
    public Users save(Users users) {
        return userRepository.save(users);
    }

    @Override
    public boolean update(Users users) {
        return userRepository.update(users);
    }

    @Override
    public boolean remove(String id) {
        return userRepository.remove(id);
    }

    @Override
    public List<Users> search() {
        return userRepository.search();
    }
}
