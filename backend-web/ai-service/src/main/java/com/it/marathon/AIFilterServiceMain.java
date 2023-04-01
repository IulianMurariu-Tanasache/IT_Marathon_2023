package com.it.marathon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.it.marathon")
public class AIFilterServiceMain {

    public static void main(String[] args) {
        SpringApplication.run(AIFilterServiceMain.class, args);
    }
}