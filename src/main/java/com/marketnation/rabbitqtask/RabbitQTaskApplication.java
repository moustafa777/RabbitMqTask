package com.marketnation.rabbitqtask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RabbitQTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitQTaskApplication.class, args);
    }


}
