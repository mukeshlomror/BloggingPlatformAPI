package com.Mukesh.BloggingPlatformAPI.repositories;

import com.Mukesh.BloggingPlatformAPI.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepo extends JpaRepository<User,Integer> {

    Optional<User> findByUserEmailAndUserPassword(String userEmail, String userPassword);
}
