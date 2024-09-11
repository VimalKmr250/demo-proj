package com.interview.demo.interviewdemo.learning;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Random;

@Slf4j
@Service
public class MyServiceImpl implements MyService{

    @Override
    public String generateIDNormal() {
        var random = new Random();
        var id = random.nextInt(50);
        return "normal-"+ id;
    }

    @Override
    public String generateUUIDDefault() {
        return MyService.super.generateUUIDDefault();
    }
}
