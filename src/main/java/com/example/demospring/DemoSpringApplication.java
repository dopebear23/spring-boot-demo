package com.example.demospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class DemoSpringApplication {
    private static final Logger logger = LoggerFactory.getLogger(DemoSpringApplication.class);

    public static void main(String[] args) {

        logger.info("Started Demo Spring Application...");
        SpringApplication.run(DemoSpringApplication.class, args);
    }

}