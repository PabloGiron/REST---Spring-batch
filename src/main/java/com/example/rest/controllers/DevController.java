package com.example.rest.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test-end-point")
public class DevController {

    @GetMapping
    public String helloWorld(){
        return "Hello world!";
    }
}
