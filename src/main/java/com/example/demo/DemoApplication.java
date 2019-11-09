package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@Slf4j
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @RequestMapping("hello")
    public Object hello(String[] args) {
//        System.out.println("hello Mr.Tree");
//        System.out.println("hello Mr.Zhu");
//        System.out.println("hello Hui");
        log.info("访问了接口http://localhost:8088/hello");
        System.out.println("hello Hui");
        return "hello";
    }

}