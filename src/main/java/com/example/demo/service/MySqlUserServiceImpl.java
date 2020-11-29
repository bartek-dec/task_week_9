package com.example.demo.service;

import com.example.demo.aspect.mysql.FindOneMySql;
import com.example.demo.aspect.mysql.ReadAllMySql;
import com.example.demo.aspect.mysql.SaveAllMySql;
import com.example.demo.aspect.mysql.SaveMySql;
import com.example.demo.domain.MySqlUser;
import com.example.demo.repository.MySqlUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MySqlUserServiceImpl implements MySqlUserService {

    private MySqlUserRepository repository;

    @Autowired
    public MySqlUserServiceImpl(MySqlUserRepository repository) {
        this.repository = repository;
    }

    @Override
    @SaveAllMySql
    public void saveAll(List<MySqlUser> users) {
        repository.saveAll(users);
    }

    @Override
    @ReadAllMySql
    public List<MySqlUser> readAll() {
        return repository.findAll();
    }

    @Override
    @SaveMySql
    public void save(MySqlUser user) {
        repository.save(user);
    }

    @Override
    @FindOneMySql
    public MySqlUser findById(Long id) {
        return repository.findById(id).get();
    }
}
