package com.tekarch.TafDatastoreService.controller;

import com.tekarch.TafDatastoreService.entities.Users;
import com.tekarch.TafDatastoreService.model.UserDTO;
import com.tekarch.TafDatastoreService.service.UserServiceImpl;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/users/register")
    public ResponseEntity<Users> createAccount(@RequestBody UserDTO user) {
        Users createdUser = userService.addUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Users>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<Users> getUserById(@PathVariable Long userId) {
        Users user = userService.getUserId(userId);
        return (user != null) ? ResponseEntity.status(HttpStatus.OK).body(user) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(user);
    }

    @PutMapping ("/users/{userId}")
    public ResponseEntity<Users> updateUser(@RequestBody UserDTO user,@PathVariable Long userId) {
        Users update = userService.updateUser(user, userId);
        return new ResponseEntity<>(update, HttpStatus.CREATED);
    }



}
