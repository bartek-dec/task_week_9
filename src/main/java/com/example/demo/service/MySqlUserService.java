package com.example.demo.service;

import com.example.demo.domain.MySqlUser;

import java.util.List;

public interface MySqlUserService {

    void saveAll(List<MySqlUser> users);

    List<MySqlUser> readAll();

    void save(MySqlUser user);

    MySqlUser findById(Long id);
}
