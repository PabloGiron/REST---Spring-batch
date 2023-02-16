package com.example.rest;


import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;

@Configuration
@Setter
@Getter
public class ConfigClass {
    public static Integer corePoolSize = 3;
    static Integer maxPoolSize = 5;
}
