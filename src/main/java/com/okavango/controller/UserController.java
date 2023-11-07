package com.okavango.controller;

import com.okavango.entity.dto.UserRegistrationDTO;
import com.okavango.entity.dto.UserMinDTO;
import com.okavango.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/users")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserMinDTO newUser(@RequestBody UserRegistrationDTO user){
        return userService.create(user);
    }

    @GetMapping
    public List<UserMinDTO> all(){
        return userService.all();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserMinDTO> findBy(@PathVariable Long id){
        return userService.findBy(id);
    }

}
