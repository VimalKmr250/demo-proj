package com.interview.demo.interviewdemo.learning;


import java.util.UUID;


public interface MyService {

    String generateIDNormal();

    default String generateUUIDDefault(){
        return "default-"+ UUID.randomUUID();
    }

    static String staticMethodToTest(){
        return "static-" + UUID.randomUUID();
    }
}
