package com.example.rest.services;

import com.example.rest.models.User;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceUsingList {

    @Autowired
    private Faker faker;

    private List <User> users = new ArrayList<>();

    @PostConstruct
    public void init(){
        for (int i = 0; i < 100; i++) {
            users.add(new User(faker.funnyName().name(),faker.pokemon().name(),faker.dragonBall().character()));
        }
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public User getUserByUsername(String username){
        return users.stream().filter(u->u.getUserName().equals(username))
                .findAny().orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("User %S not found",username)));
    }

    public User createUser(User user){
        if(users.stream().anyMatch(u->u.getUserName().equals(user.getUserName()))){
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    String.format("The username %s already exist",user.getUserName()));
        }
        users.add(user);
        return user;
    }

    public User updateUser(User user, String username){
        User userToBeUpdated = getUserByUsername(username);
        userToBeUpdated.setNickName(user.getNickName());
        userToBeUpdated.setPassword(user.getPassword());

        return userToBeUpdated;
    }

    public void deleteUser(String username){
        User userByUsername = getUserByUsername(username);
        users.remove(userByUsername);
    }
}