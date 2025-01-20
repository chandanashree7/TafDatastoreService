package com.tekarch.TafDatastoreService.service.Interface;

import com.tekarch.TafDatastoreService.entities.Users;
import com.tekarch.TafDatastoreService.model.UserRequest;
import com.tekarch.TafDatastoreService.model.UserResponse;

import java.util.List;

public interface UserServiceInterface {

    UserResponse createUser(UserRequest users);
    List<UserResponse> getAllUsers();
    UserResponse updateUser(UserRequest user, Long userId);
    UserResponse getUserId(Long userId);
}
