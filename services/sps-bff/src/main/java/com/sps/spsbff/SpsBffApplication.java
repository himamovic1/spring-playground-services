package com.sps.spsbff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpsBffApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpsBffApplication.class, args);
    }

}
