package com.simple.boottest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.mail.MessagingException;


@RestController
public class UserController {
	
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/find-username")
    public ResponseEntity<?> findUsernameByEmail(@RequestParam String email) {
        Vo user = userRepository.findByEmail(email);

        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("등록된 아이디가 없습니다.");
        }

        return ResponseEntity.ok(user.getId());
    }

}


// http://localhost:8080/find-username?email=user@example.com


