package com.interview.demo.interviewdemo.controller;

import com.interview.demo.interviewdemo.learning.LearnInterfaces;
import com.interview.demo.interviewdemo.learning.LearnThreading;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Slf4j
@RestController("/v1")
public class DemoController {

    @Autowired
    private LearnInterfaces interfaceLearn;

    @GetMapping (value = "/trigger")
    public String triggerCode() {

        return "Triggered";
    }

    @GetMapping("/interface")
    public String learnStaticDefault(){
        var id1 = interfaceLearn.generateIDNormal();
        var id2 = interfaceLearn.generateUUIDDefault();
        var id3 = LearnInterfaces.staticMethodToTest();

        return id1 + " " + id2 + " " + id3;
    }

    @GetMapping("/thread")
    public String learnThread(){

        List<LearnThreading> integerList =  new ArrayList<>();

        for(int i=0;i<=100;i++){
            integerList.add(new LearnThreading());
        }

        integerList.stream().parallel()
                .forEach(Thread::start);


        return "foo";
    }

    @GetMapping("/linkedList")
    public String learnlinkedList(){

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        log.info("Link list contents are {}", linkedList);

        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("a");
        stringArrayList.add("b");
        stringArrayList.add("c");

        log.info("stringArrayList contents are {}", stringArrayList);

        return "foo";
    }


}

