package com.tekarch.TafDatastoreService.service;


import com.tekarch.TafDatastoreService.entities.Users;
import com.tekarch.TafDatastoreService.model.UserDTO;
import com.tekarch.TafDatastoreService.repository.UserRepository;
import com.tekarch.TafDatastoreService.service.Interface.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserServiceInterface {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Users addUser(UserDTO userDTO) {
        Users user=new Users();
        user.setUserName(userDTO.getUserName());
        user.setEmail(userDTO.getEmail());
        user.setPhone(userDTO.getPhone());
        user.setCreatedAt(LocalDateTime.now());
        return userRepository.save(user);
    }

    @Override
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Users updateUser(UserDTO userDTO, Long userId) {
        Users user=new Users();
        user.setId(userId);
        user.setUserName(userDTO.getUserName());
        user.setEmail(userDTO.getEmail());
        user.setPhone(userDTO.getPhone());
        user.setCreatedAt(LocalDateTime.now());
        return userRepository.save(user);
    }

    @Override
    public Users getUserId(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }


}
