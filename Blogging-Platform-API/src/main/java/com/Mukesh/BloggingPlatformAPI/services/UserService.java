package com.Mukesh.BloggingPlatformAPI.services;

import com.Mukesh.BloggingPlatformAPI.models.User;
import com.Mukesh.BloggingPlatformAPI.models.dto.UserDto;
import com.Mukesh.BloggingPlatformAPI.repositories.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    IUserRepo userRepo;


    // Creating a new user
    public User createUser(User user){
       User savedUser =  userRepo.save(user);
        return savedUser;
    }

    // updating the NAME and ABOUT info of existing user
    public void updateUser(Integer id, String name, String about){

        User existingUser = userRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User with id %d not found", id)));
        existingUser.setUserName(name);
        existingUser.setAbout(about);

        userRepo.save(existingUser);

    }

    public Optional<User> getUserById(Integer id){

       // User existingUser = userRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User with id %d not found", id)));
       // return Optional.ofNullable(existingUser);
      return userRepo.findById(id);

    }

    public List<User> getAllUsers(){

      return userRepo.findAll();

    }

    public String deleteUser(Integer id){

        User existingUser = userRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User with id %d not found", id)));
        userRepo.delete(existingUser);
        return "User with id ::=> "+id+" is successfully deleted";

    }

    // register the user
    public String registerUser(User user){
        if(user.getUserEmail() ==null || user.getUserPassword()==null) {
            return null;
        }else{
            userRepo.save(user);
        }
        return "User is successfully Registered!!!";
    }

    // Authenticate User
    public User authenticateUser(String userEmail, String userPassword){
        return userRepo.findByUserEmailAndUserPassword(userEmail, userPassword).orElse(null);
    }
}
