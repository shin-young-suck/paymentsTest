package com.simple.boottest.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.persistence.Entity;

@Repository
public interface UserRepository extends JpaRepository<Vo, Integer> {

    Vo findByEmail(String email);
    
}
