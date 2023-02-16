package com.example.rest.controllers;

import com.example.rest.models.User;
import com.example.rest.services.UserServiceUsingList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UserControllerUsingList {

    @Autowired
    private UserServiceUsingList userServiceUsingList;

    @GetMapping
    public ResponseEntity<List<User>> get(){
        return new ResponseEntity<List<User>>(userServiceUsingList.getUsers(), HttpStatus.OK);
    }

    @GetMapping(value = "/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable("username") String username){
        return new ResponseEntity<User>(userServiceUsingList.getUserByUsername(username), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        return new ResponseEntity<User>(userServiceUsingList.createUser(user),HttpStatus.CREATED);
    }

    @PutMapping(value = "/{username}")
    public ResponseEntity<User> updateUser(@PathVariable("username") String username, @RequestBody User user){
        return new ResponseEntity<User>(userServiceUsingList.updateUser(user, username),HttpStatus.OK);
    }

    @DeleteMapping(value = "/{username}")
    public ResponseEntity<Void> deleteUser(@PathVariable("username") String username){
        userServiceUsingList.deleteUser(username);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
