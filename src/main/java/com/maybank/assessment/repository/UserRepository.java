package com.maybank.assessment.repository;

import com.maybank.assessment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}