package com.example._5.controller;


import com.example._5.model.User;
import com.example._5.service.impl.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {

    private EmailServiceImpl emailService;

    @Autowired
    public EmailController(EmailServiceImpl emailService) {
        this.emailService = emailService;

    }

    @GetMapping("/sendEmail")
    public ResponseEntity<String> sendMessage(){

        try{
            emailService.sendEmail();
        }catch (MailException matchException){
            throw new RuntimeException();
        }
        return ResponseEntity.ok("Check your email :)");
    }
}
