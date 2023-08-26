package com.vinorsoft.giamdoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class GiamDocApplication {

    public static void main(String[] args) {
        SpringApplication.run(GiamDocApplication.class, args);
    }

}
