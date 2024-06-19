package com.simple.boottest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PasswordResetController {
	
	@Autowired
    private PasswordResetService passwordResetService;
	
	@Autowired
	Repository mr;

    @GetMapping("/request-password-reset")
    public String requestPasswordReset(@RequestParam("email") String email) {
        passwordResetService.createPasswordResetToken(email);
        return "Password reset email sent.";
    }
    
    
    
    @GetMapping("/reset-password")
    public String resetPassword(@RequestParam("token") String token,
                                @RequestParam("newPassword") String newPassword) {
        passwordResetService.resetPassword(token, newPassword);
        return "Password successfully reset";
    }
    
    @GetMapping("/html")
    public ResponseEntity<String> getHtml() {
        String htmlContent = "<html>" +
                             "<head><title>HTML Response</title></head>" +
                             "<body>" +
                             "<div class='button-container'>" +
                             "<button>아이디 찾기</button>" +
                             "<button>비밀번호 찾기</button>" +
                             "</div>" +
                             "</body>" +
                             "</html>";

        // ResponseEntity를 사용하여 HTML을 반환하고, Content-Type을 text/html로 설정
        return ResponseEntity.status(HttpStatus.OK)
                             .header("Content-Type", "text/html; charset=UTF-8")
                             .body(htmlContent);
    }
}
