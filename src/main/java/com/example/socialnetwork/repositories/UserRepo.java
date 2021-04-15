package com.example.socialnetwork.repositories;

import com.example.socialnetwork.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findByFirstName(String firstName);
    Optional<User> findByLastName(String lastName);
    Optional<User> findByFirstNameAndLastName(String firstName, String lastName);
}