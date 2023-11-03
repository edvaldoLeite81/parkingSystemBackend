package com.okavango.service;

import com.okavango.entity.User;
import com.okavango.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User create(User user){
       return userRepository.save(user);
    }
}
