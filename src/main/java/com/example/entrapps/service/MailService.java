package com.example.entrapps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendContactEmail(String from, String name, String message) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setFrom(from);
        mail.setTo("admin@ngo-anderlecht.be");
        mail.setSubject("Contactformulier van " + name);
        mail.setText(message);
        mailSender.send(mail);
    }
}
