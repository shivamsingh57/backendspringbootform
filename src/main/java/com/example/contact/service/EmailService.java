package com.example.contact.service;

import com.example.contact.dto.ContactFormDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendContactEmail(ContactFormDTO form) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("your.email@gmail.com");
        message.setSubject("New Contact Form Submission");
        message.setText("Name: " + form.getName() +
                        "\nEmail: " + form.getEmail() +
                        "\nMessage: " + form.getMessage());
        mailSender.send(message);
    }
}
