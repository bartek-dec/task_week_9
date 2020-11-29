package com.example.demo.service;

import com.example.demo.aspect.mongo.FindOneMongo;
import com.example.demo.aspect.mongo.ReadAllMongo;
import com.example.demo.aspect.mongo.SaveAllMongo;
import com.example.demo.aspect.mongo.SaveMongo;
import com.example.demo.domain.MongoUser;
import com.example.demo.repository.MongoUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MongoUserServiceImpl implements MongoUserService {

    private MongoUserRepository repository;

    @Autowired
    public MongoUserServiceImpl(MongoUserRepository repository) {
        this.repository = repository;
    }

    @Override
    @SaveAllMongo
    public void saveAll(List<MongoUser> users) {
        repository.saveAll(users);
    }

    @Override
    @ReadAllMongo
    public List<MongoUser> readAll() {
        return repository.findAll();
    }

    @Override
    @SaveMongo
    public void save(MongoUser user) {
        repository.save(user);
    }

    @Override
    @FindOneMongo
    public MongoUser findById(String id) {
        return repository.findById(id).get();
    }
}
