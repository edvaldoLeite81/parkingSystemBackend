package com.okavango.service;

import com.okavango.entity.User;
import com.okavango.entity.dto.UserRegistrationDTO;
import com.okavango.entity.dto.UserMinDTO;
import com.okavango.exception.ResourceNotFoundException;
import com.okavango.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    //create
    @Transactional
    public UserMinDTO create(UserRegistrationDTO newUser) {
        User user = new User(newUser.getUserName(), newUser.getPassword());
        user = userRepository.save(user);
        return new UserMinDTO(user);
    }

    // list
    @Transactional(readOnly = true)
    public List<UserMinDTO> all(){
        return userRepository.findAll().stream().map(UserMinDTO::new).toList();
    }

    // find by id
    @Transactional(readOnly = true)
    public ResponseEntity<UserMinDTO> findBy(Long id){
        String message = "Resource whith id " + id + " not found";

        Optional<User> u = userRepository.findById(id);

        if(u.isPresent()){
            User user = u.get();
            UserMinDTO userMinDTO = new UserMinDTO(user);
            return ResponseEntity.ok(userMinDTO);
        }
        else throw new ResourceNotFoundException(id,message);
    }
}




