package com.okavango.controller;

import com.okavango.entity.User;
import com.okavango.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/users")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public User newUser(@RequestBody User user){
        return userService.create(user);
    }

}
