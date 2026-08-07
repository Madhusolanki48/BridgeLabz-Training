package com.example.greetings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class GreetingsApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(GreetingsApplication.class, args);
    }

    //needed when deploying WAR file on external Tomcat.
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(GreetingsApplication.class);
    }
}
