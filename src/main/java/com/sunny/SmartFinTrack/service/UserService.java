package com.sunny.SmartFinTrack.service;

import com.sunny.SmartFinTrack.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
