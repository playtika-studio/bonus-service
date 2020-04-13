package com.bonus.service.bonus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BonusApplication {

    public static void main(String[] args) {
        SpringApplication.run(BonusApplication.class, args);
    }

}
