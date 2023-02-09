package com.example.calculation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.calculation.model.User;

@Repository
public interface UserRepository  extends JpaRepository<User, String>{

}
