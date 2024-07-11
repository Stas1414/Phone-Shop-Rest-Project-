package com.example._5.service.impl;


import com.example._5.model.User;
import com.example._5.repository.UserRepository;
import com.example._5.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    private JavaMailSender javaMailSender;

    private UserRepository userRepository;

    @Autowired
    public EmailServiceImpl(JavaMailSender javaMailSender, UserRepository userRepository) {
        this.javaMailSender = javaMailSender;
        this.userRepository = userRepository;
    }

    @Override
    public void sendEmail() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        User user = userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        simpleMailMessage.setTo(user.getEmail());
        simpleMailMessage.setSubject("Оплата телефонов");
        simpleMailMessage.setText("Оплата прошла успешно");
        javaMailSender.send(simpleMailMessage);
    }
}
