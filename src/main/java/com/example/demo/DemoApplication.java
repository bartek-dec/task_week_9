package com.example.demo;

import com.example.demo.domain.Gender;
import com.example.demo.domain.MongoUser;
import com.example.demo.domain.MySqlUser;
import com.example.demo.service.MongoUserService;
import com.example.demo.service.MySqlUserService;
import com.example.demo.util.DataLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

    private DataLoader dataLoader;
    private MySqlUserService mySqlService;
    private MongoUserService mongoUserService;

    @Autowired
    public DemoApplication(DataLoader dataLoader,
                           MySqlUserService mySqlService,
                           MongoUserService mongoUserService) {
        this.dataLoader = dataLoader;
        this.mySqlService = mySqlService;
        this.mongoUserService = mongoUserService;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void run() throws IOException {
        List<MySqlUser> mySqlUsers = dataLoader.readMySqlUsers();
        List<MongoUser> mongoUsers = dataLoader.readMongoUsers();

        System.out.println("Save all:");
        mySqlService.saveAll(mySqlUsers);

        System.out.println("Read all:");
        List<MySqlUser> foundMySqlUsers = mySqlService.readAll();

        MySqlUser newMySqlUser = new MySqlUser();
        newMySqlUser.setFirstName("MySql");
        newMySqlUser.setLastName("User");
        newMySqlUser.setEmail("someEmail");
        newMySqlUser.setGender(Gender.Female);
        newMySqlUser.setIpAddress("Some address");

        System.out.println("Save one:");
        mySqlService.save(newMySqlUser);

        System.out.println("Find one:");
        mySqlService.findById(666L);

        System.out.println("##################################################");

        System.out.println("Save all:");
        mongoUserService.saveAll(mongoUsers);

        System.out.println("Read all:");
        List<MongoUser> foundMongoUsers = mongoUserService.readAll();

        MongoUser newMongoUser = new MongoUser();
        newMongoUser.setFirstName("MySql");
        newMongoUser.setLastName("User");
        newMongoUser.setEmail("someEmail");
        newMongoUser.setGender(Gender.Female);
        newMongoUser.setIpAddress("Some address");

        System.out.println("Save one:");
        mongoUserService.save(newMongoUser);

        System.out.println("Find one:");
        mongoUserService.findById(foundMongoUsers.get(666).getId());
    }

}
