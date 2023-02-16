package com.example.rest.services;

import com.example.rest.ConfigClass;
import com.example.rest.entities.User;
import com.example.rest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    ConfigClass configClass = new ConfigClass();

    public Page<User> getUsers(int page, int size){
        System.out.println("BBBBBBBBBBB");
        configClass.corePoolSize++;
        System.out.println(configClass.corePoolSize);
        return userRepository.findAll(PageRequest.of(page,size));
    }

    public List<String> getUsernames(){
        return userRepository.findUsernames();
    }

    public User getUserById(Integer userId){
        return userRepository.findById(userId).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Id %d doesn't exist", userId)));
    }

    public User getUserByUsername(String username){
        return userRepository.findByUsername(username).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("The user %d doesn't exist", username)));
    }


}