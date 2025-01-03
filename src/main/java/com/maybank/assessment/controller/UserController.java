package com.maybank.assessment.controller;

import com.maybank.assessment.dto.UserDTO;
import com.maybank.assessment.entity.User;
import com.maybank.assessment.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody UserDTO userDTO) {
        log.info("Request to create user: {}", userDTO);
        User createdUser = userService.createUser(userDTO);
        log.info("Response after creating user: {}", createdUser);
        return createdUser;
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Integer id) {
        log.info("Request to get user with ID: {}", id);
        User user = userService.getUser(id);
        log.info("Response after getting user: {}", user);
        return user;
    }

    @GetMapping
    public Page<User> getUsers(@RequestParam(defaultValue = "0") int page,
                               @RequestParam(defaultValue = "10") int size) {
        log.info("Request to get users with page: {} and size: {}", page, size);
        Page<User> users = userService.getUsersWithPagination(page, size);
        log.info("Response after getting users: {}", users);
        return users;
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Integer id, @RequestBody UserDTO userDTO) {
        log.info("Request to update user with ID: {}, data: {}", id, userDTO);
        User updatedUser = userService.updateUser(id, userDTO);
        log.info("Response after updating user: {}", updatedUser);
        return updatedUser;
    }
}
