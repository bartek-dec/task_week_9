package com.example.demo.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MongoAspect {

    @Before("@annotation(com.example.demo.aspect.mongo.SaveAllMongo)")
    private void beforeSaveAll() {
        System.out.println("Before saveAll: " + System.currentTimeMillis());
    }

    @After("@annotation(com.example.demo.aspect.mongo.SaveAllMongo)")
    private void afterSaveAll() {
        System.out.println("After saveAll: " + System.currentTimeMillis());
        System.out.println();
    }

    @Before("@annotation(com.example.demo.aspect.mongo.ReadAllMongo)")
    private void beforeReadAll() {
        System.out.println("Before readAll: " + System.currentTimeMillis());
    }

    @After("@annotation(com.example.demo.aspect.mongo.ReadAllMongo)")
    private void afterReadAll() {
        System.out.println("After readAll: " + System.currentTimeMillis());
        System.out.println();
    }

    @Before("@annotation(com.example.demo.aspect.mongo.SaveMongo)")
    private void beforeSave() {
        System.out.println("Before save: " + System.currentTimeMillis());
    }

    @After("@annotation(com.example.demo.aspect.mongo.SaveMongo)")
    private void afterSave() {
        System.out.println("After save: " + System.currentTimeMillis());
        System.out.println();
    }

    @Before("@annotation(com.example.demo.aspect.mongo.FindOneMongo)")
    private void beforeFindOne() {
        System.out.println("Before find by id: " + System.currentTimeMillis());
    }

    @After("@annotation(com.example.demo.aspect.mongo.FindOneMongo)")
    private void afterFindOne() {
        System.out.println("After save: " + System.currentTimeMillis());
        System.out.println();
    }
}
