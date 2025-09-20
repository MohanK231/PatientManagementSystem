package com.example.securityservice.service;

import com.example.securityservice.dto.LoginRequestDTO;
import com.example.securityservice.model.User;
import com.example.securityservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    public  final UserRepository  userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository=userRepository;
    }
    public Optional<User> findByEmail(String email){
        return userRepository.findByEmail(email);
    }
}
