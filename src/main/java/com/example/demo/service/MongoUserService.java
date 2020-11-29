package com.example.demo.service;

import com.example.demo.domain.MongoUser;

import java.util.List;

public interface MongoUserService {

    void saveAll(List<MongoUser> users);

    List<MongoUser> readAll();

    void save(MongoUser user);

    MongoUser findById(String id);
}
