package com.example.rest.repositories;

import com.example.rest.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    public Optional<User> findByUsername(String username);
    public Optional<User> findByUsernameAndPassword(String username, String password);

    @Query("SELECT u.username FROM User u")
    public List<String> findUsernames();
}
