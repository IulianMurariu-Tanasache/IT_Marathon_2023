package com.it.marathon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication(scanBasePackages = "com.it.marathon")
public class LoadBalancerOperatorMain {

    public static void main(String[] args) {
        SpringApplication.run(LoadBalancerOperatorMain.class, args);
    }
}