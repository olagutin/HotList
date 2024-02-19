package com.hotlist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class HotListApplication {
    public static void main(String[] args) {
        SpringApplication.run(HotListApplication.class, args);
    }
}
