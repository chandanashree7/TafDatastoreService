package com.tekarch.TafDatastoreService.service;


import com.tekarch.TafDatastoreService.entities.Users;
import com.tekarch.TafDatastoreService.model.UserRequest;
import com.tekarch.TafDatastoreService.model.UserResponse;
import com.tekarch.TafDatastoreService.repository.UserRepository;
import com.tekarch.TafDatastoreService.service.Interface.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserServiceInterface {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserResponse createUser(UserRequest userRequest) {
        Users user=new Users();
        user.setUserName(userRequest.getUserName());
        user.setEmail(userRequest.getEmail());
        user.setPhone(userRequest.getPhone());
        user.setCreatedAt(LocalDateTime.now());
        Users response = userRepository.save(user);
        return mapUserDetails(response);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        List<Users> details = userRepository.findAll();
        List<UserResponse> users = new ArrayList<>();
        for (Users detail : details) {
            users.add(mapUserDetails(detail));
        }
        return users;
    }

    @Override
    public UserResponse updateUser(UserRequest userRequest, Long userId) {
        Users user=new Users();
        user.setId(userId);
        user.setUserName(userRequest.getUserName());
        user.setEmail(userRequest.getEmail());
        user.setPhone(userRequest.getPhone());
        user.setCreatedAt(LocalDateTime.now());
        Users response = userRepository.save(user);
        return mapUserDetails(response);
    }

    @Override
    public UserResponse getUserId(Long userId) {
        Users user = userRepository.findById(userId).orElse(null);
        return mapUserDetails(user);
    }

    private UserResponse mapUserDetails(Users data){
        UserResponse response = new UserResponse();
        if (data != null) {
            response.setId(data.getId());
            response.setUserName(data.getUserName());
            response.setEmail(data.getEmail());
            response.setPhone(data.getPhone());
        }
        return response;
    }
}
