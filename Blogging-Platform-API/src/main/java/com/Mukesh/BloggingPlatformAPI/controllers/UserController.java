package com.Mukesh.BloggingPlatformAPI.controllers;

import com.Mukesh.BloggingPlatformAPI.models.User;
import com.Mukesh.BloggingPlatformAPI.models.dto.UserDto;
import com.Mukesh.BloggingPlatformAPI.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/users")
public class UserController {
    @Autowired
    UserService userService;

    //POST --> Creating User

    @PostMapping("/create")
    public User createUser(@Valid @RequestBody User user){
        return userService.createUser(user);
    }

    //GET --> get all users
    @GetMapping("/getAll")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/getOne/{id}")
    public Optional<User> getUserById(Integer id){
        return userService.getUserById(id);
    }

    //PUT --> update the username and about information

    @PutMapping("/update/{id}/{name}/{about}")
    public String updateUser(@Valid @PathVariable Integer id, @PathVariable String name, @PathVariable String about){
        userService.updateUser(id,name,about);
        return "User Information successfully Updated";

    }

    //DELETE -->
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable Integer id){
        return userService.deleteUser(id);
    }

    //POST --> to register the user
    @PostMapping("/register")
    public String registerUser(@RequestBody User user){
        return userService.registerUser(user);
    }

    //GET --> Login the user
    @GetMapping("/login")
    public User loginUser(@RequestParam String userEmail, @RequestParam String userPassword){
        return userService.authenticateUser(userEmail,userPassword);
    }
}
