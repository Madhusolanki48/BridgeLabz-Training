package com.example.fundoonotes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@SpringBootApplication
public class FundooNotesApplication {

    public static void main(String[] args) {
        SpringApplication.run(FundooNotesApplication.class, args);
    }

}
