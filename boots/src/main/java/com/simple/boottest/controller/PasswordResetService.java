package com.simple.boottest.controller;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class PasswordResetService {
	    @Autowired
	    private UserRepository userRepository;

	    @Autowired
	    private PasswordResetTokenRepository tokenRepository;

	    @Autowired
	    private JavaMailSender mailSender;

	    public void createPasswordResetToken(String userEmail) {
	        Vo user = userRepository.findByEmail(userEmail);
	        if (user == null) {
	            throw new RuntimeException("User not found");
	        }

	        String token = UUID.randomUUID().toString();
	        PasswordResetToken resetToken = new PasswordResetToken();
	        resetToken.setToken(token);
	        resetToken.setUserEmail(userEmail);
	        resetToken.setExpirationDate(LocalDateTime.now().plusHours(1));
	        tokenRepository.save(resetToken);

	        sendResetEmail(userEmail, token);
	    }

	    private void sendResetEmail(String email, String token) {
	        String resetUrl = "http://localhost:8080/reset-password?token=" + token;

	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo(email);
	        message.setSubject("Password Reset Request");
	        message.setText("To reset your password, click the link below:\n" + resetUrl);

	        mailSender.send(message);
	    }

	    public void resetPassword(String token, String newPassword) {
	        PasswordResetToken resetToken = tokenRepository.findByToken(token);
	        if (resetToken == null || resetToken.getExpirationDate().isBefore(LocalDateTime.now())) {
	            throw new RuntimeException("Invalid or expired token");
	        }

	        Vo user = userRepository.findByEmail(resetToken.getUserEmail());
	        user.setPw(newPassword);  // 비밀번호는 해싱하여 저장하는 것이 좋습니다.
	        userRepository.save(user);
	        tokenRepository.delete(resetToken);
	    }
}
