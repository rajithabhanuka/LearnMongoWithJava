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
    public void inti() {
        MockitoAnnotations.initMocks(this);
        saveUsers();

    }

    public void saveUsers() {

        String u1 = "[{\n" +
                "\t\"id\" : \"12345\",\n" +
                "\t\"name\" : \"Sarah\",\n" +
                "\t\"age\" : \"29\",\n" +
                "\t\"gender\": \"Female\",\n" +
                "\t\"country\" : \"German\"\n" +
                "},\n" +
                "{\n" +
                "\t\"id\" : \"54321\",\n" +
                "\t\"name\" : \"Bhanuka\",\n" +
                "\t\"age\" : \"27\",\n" +
                "\t\"gender\": \"Male\",\n" +
                "\t\"country\" : \"Sri Lanka\"\n" +
                "}]\n";

        try {
            Users users[] = new ObjectMapper().readValue(u1, Users[].class);

            for (Users users1 : users) {
                userRepository.save(users1);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void searchTest(){
        List<Users> users = userRepository.search();
        Assert.assertTrue("Sarah".equals(users.get(0).getName()));
    }

}
