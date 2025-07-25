package com.example.contact.controller;

import com.example.contact.dto.ContactFormDTO;
import com.example.contact.service.EmailService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api") // Base path
@CrossOrigin(origins = "*") // Allow all origins for frontend access
public class ContactController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/contact")
    public ResponseEntity<String> submitForm(@Valid @RequestBody ContactFormDTO form) {
        try {
            emailService.sendContactEmail(form);
            return ResponseEntity.ok("Message sent successfully!");
        } catch (Exception e) {
            e.printStackTrace(); // Log error on server console
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error sending message: " + e.getMessage());
        }
    }
}
