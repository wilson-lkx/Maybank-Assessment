package com.maybank.assessment.service;

import com.maybank.assessment.dto.UserDTO;
import com.maybank.assessment.entity.User;
import com.maybank.assessment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public User createUser(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setAge(userDTO.getAge());
        return userRepository.save(user);
    }

    @Override
    public User getUser(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public Page<User> getUsersWithPagination(int page, int size) {
        return userRepository.findAll(PageRequest.of(page, size));
    }

    @Transactional
    public User updateUser(Integer id, UserDTO userDTO) {
        // Find the existing user by ID
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        // Update user details
        existingUser.setName(userDTO.getName());
        existingUser.setEmail(userDTO.getEmail());
        existingUser.setAge(userDTO.getAge());

        // Save the updated user
        return userRepository.save(existingUser);
    }
}
