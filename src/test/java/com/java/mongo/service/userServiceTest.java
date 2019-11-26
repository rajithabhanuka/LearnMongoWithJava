package com.java.mongo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.mongo.MongoApplicationTests;
import com.java.mongo.dao.userRepository;
import com.java.mongo.model.Users;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class userServiceTest extends MongoApplicationTests {

    @InjectMocks
    @Autowired
    userServiceImpl userService;

    @Autowired
    userRepository userRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        saveUser();
    }

    public void saveUser() {
        String userList = "[{\n" +
                "\t\"name\" : \"Bhanuka\",\n" +
                "\t\"age\" : \"27\",\n" +
                "\t\"gender\": \"Male\",\n" +
                "\t\"country\" : \"Srilanka\"\n" +
                "},{\n" +
                "\t\"name\" : \"Ravindu\",\n" +
                "\t\"age\" : \"28\",\n" +
                "\t\"gender\": \"Male\",\n" +
                "\t\"country\" : \"India/**/\"\n" +
                "}]";


        try {
            Users users[] = new ObjectMapper().readValue(userList, Users[].class);

            for (Users users1 : users) {
                userRepository.save(users1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void searchTest() {
        List<Users> users = userService.search();

        Assert.assertTrue("Bhanuka".equals(users.get(0).getName()));

    }

}
