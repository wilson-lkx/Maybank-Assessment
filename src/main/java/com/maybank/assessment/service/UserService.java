package com.maybank.assessment.service;

import com.maybank.assessment.dto.UserDTO;
import com.maybank.assessment.entity.User;
import org.springframework.data.domain.Page;

public interface UserService {
    User createUser(UserDTO userDTO);
    User getUser(Integer id);
    Page<User> getUsersWithPagination(int page, int size);
    User updateUser(Integer id, UserDTO userDTO);
}