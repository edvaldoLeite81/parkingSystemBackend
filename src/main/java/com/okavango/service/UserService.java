package com.okavango.service;

import com.okavango.entity.User;
import com.okavango.entity.dto.UserRegistrationDTO;
import com.okavango.entity.dto.UserResponseDTO;
import com.okavango.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    //create
    @Transactional
    public UserResponseDTO create(UserRegistrationDTO newUser) {
        User user = new User(newUser.getUserName(), newUser.getPassword());
        user = userRepository.save(user);
        return new UserResponseDTO(user);
    }

    // list
    @Transactional(readOnly = true)
    public List<UserResponseDTO> all(){
        return userRepository.findAll().stream().map(UserResponseDTO::new).toList();
    }

    // find by id
    @Transactional(readOnly = true)
    public ResponseEntity<UserResponseDTO> findBy(Long id){
        String message = "Resource whith id " + id + " not found";

        Optional<User> u = userRepository.findById(id);

        if(u.isPresent()){
            User user = u.get();
            UserResponseDTO userResponseDTO = new UserResponseDTO(user);
            return ResponseEntity.ok(userResponseDTO);
        }
        else throw new RuntimeException(message);
    }
}




