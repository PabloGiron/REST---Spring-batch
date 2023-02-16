package com.example.rest.controllers;


import com.example.rest.entities.User;
import com.example.rest.services.UserService;
import com.example.rest.services.UserServiceUsingList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<Page<User>> getUsers(
            @RequestParam( required = false, value = "page", defaultValue = "0") int page,
            @RequestParam( required = false, value = "size", defaultValue = "250") int size){
        return new ResponseEntity<>( userService.getUsers(page, size), HttpStatus.OK );
    }

    @GetMapping("/usernames")
    public ResponseEntity<List<String>> getUsernames(){
        return new ResponseEntity<List<String>>( userService.getUsernames(), HttpStatus.OK );
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId")Integer userId){
        return new ResponseEntity<>( userService.getUserById(userId), HttpStatus.OK );
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<User> getUserById(@PathVariable("username")String username){
        return new ResponseEntity<>( userService.getUserByUsername(username), HttpStatus.OK );
    }
}
