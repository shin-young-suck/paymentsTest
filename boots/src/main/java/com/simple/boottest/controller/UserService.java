package com.simple.boottest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class UserService {

//    @Autowired
//    private JavaMailSender javaMailSender;
//
//    @Autowired
//    private SpringTemplateEngine templateEngine;
//
//    public void sendUsernameEmail(String to, String username) throws MessagingException {
//        MimeMessage message = javaMailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(message, true);
//
//        helper.setTo(to);
//        helper.setSubject("사용자 아이디 안내");
//
//        Context context = new Context();
//        context.setVariable("username", username);
//        
//        String htmlContent = templateEngine.process("username-email", context);
//        helper.setText(htmlContent, true);
//
//        javaMailSender.send(message);
//    }
}
