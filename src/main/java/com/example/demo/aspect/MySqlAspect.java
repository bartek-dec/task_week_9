package com.example.demo.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MySqlAspect {

    @Before("@annotation(com.example.demo.aspect.mysql.SaveAllMySql)")
    private void beforeSaveAll() {
        System.out.println("Before saveAll: " + System.currentTimeMillis());
    }

    @After("@annotation(com.example.demo.aspect.mysql.SaveAllMySql)")
    private void afterSaveAll() {
        System.out.println("After saveAll: " + System.currentTimeMillis());
        System.out.println();
    }

    @Before("@annotation(com.example.demo.aspect.mysql.ReadAllMySql)")
    private void beforeReadAll() {
        System.out.println("Before readAll: " + System.currentTimeMillis());
    }

    @After("@annotation(com.example.demo.aspect.mysql.ReadAllMySql)")
    private void afterReadAll() {
        System.out.println("After readAll: " + System.currentTimeMillis());
        System.out.println();
    }

    @Before("@annotation(com.example.demo.aspect.mysql.SaveMySql)")
    private void beforeSave() {
        System.out.println("Before save: " + System.currentTimeMillis());
    }

    @After("@annotation(com.example.demo.aspect.mysql.SaveMySql)")
    private void afterSave() {
        System.out.println("After save: " + System.currentTimeMillis());
        System.out.println();
    }

    @Before("@annotation(com.example.demo.aspect.mysql.FindOneMySql)")
    private void beforeFindOne() {
        System.out.println("Before find by id: " + System.currentTimeMillis());
    }

    @After("@annotation(com.example.demo.aspect.mysql.FindOneMySql)")
    private void afterFindOne() {
        System.out.println("After save: " + System.currentTimeMillis());
        System.out.println();
    }
}
