package com.tekarch.TafDatastoreService.controller;

import com.tekarch.TafDatastoreService.model.UserRequest;
import com.tekarch.TafDatastoreService.model.UserResponse;
import com.tekarch.TafDatastoreService.service.UserServiceImpl;
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
    public ResponseEntity<UserResponse> createAccount(@RequestBody UserRequest userRequest) {
        UserResponse response = userService.createUser(userRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long userId) {
        UserResponse response = userService.getUserId(userId);
        return (response != null) ? ResponseEntity.status(HttpStatus.OK).body(response) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @PutMapping ("/users/{userId}")
    public ResponseEntity<UserResponse> updateUser(@RequestBody UserRequest user, @PathVariable Long userId) {
        UserResponse response = userService.updateUser(user, userId);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
