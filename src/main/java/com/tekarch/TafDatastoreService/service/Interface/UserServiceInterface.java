package com.tekarch.TafDatastoreService.service.Interface;

import com.tekarch.TafDatastoreService.entities.Users;
import com.tekarch.TafDatastoreService.model.UserDTO;

import java.util.List;

public interface UserServiceInterface {

    Users addUser(UserDTO users);
    List<Users> getAllUsers();
    Users updateUser(UserDTO user, Long userId);
    Users getUserId(Long userId);
}
