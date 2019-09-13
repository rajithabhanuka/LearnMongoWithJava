package com.java.mongo.dao;

import com.java.mongo.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class userRepositoryImpl implements userRepository{

    @Autowired private MongoTemplate mongoTemplate;

    @Override
    public Users save(Users users) {
        return mongoTemplate.save(users);
    }

    @Override
    public boolean update(Users users) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(users.getId()));

        Update update = new Update();
        update.set("name", users.getName());
        update.set("age", users.getAge());
        update.set("gender", users.getGender());
        update.set("country", users.getCountry());

        return mongoTemplate.updateFirst(query, update, Users.class).wasAcknowledged();
    }

    @Override
    public boolean remove(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        return mongoTemplate.remove(query, Users.class).wasAcknowledged();
    }

    @Override
    public List<Users> search() {
        return mongoTemplate.findAll(Users.class);
    }
}
