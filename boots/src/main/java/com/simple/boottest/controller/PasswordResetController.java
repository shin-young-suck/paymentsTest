package com.simple.boottest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PasswordResetController {
	
	@Autowired
    private PasswordResetService passwordResetService;

    @GetMapping("/request-password-reset")
    public String requestPasswordReset(@RequestParam("email") String email) {
        passwordResetService.createPasswordResetToken(email);
        return "Password reset email sent.";
    }

    @PostMapping("/reset-password")
    public String resetPassword(@RequestParam("token") String token,
                                @RequestParam("newPassword") String newPassword) {
        passwordResetService.resetPassword(token, newPassword);
        return "Password successfully reset";
    }

}
