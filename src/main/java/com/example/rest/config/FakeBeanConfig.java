package com.example.rest.config;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FakeBeanConfig {

    @Bean
    public Faker getFaker() {
        return new Faker();
    }
}
