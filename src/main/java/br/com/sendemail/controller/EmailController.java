package br.com.sendemail.controller;

import br.com.sendemail.dtos.Email;
import br.com.sendemail.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping
    public ResponseEntity<Map<String, String>> sendEmail(@RequestBody Email email) {
        emailService.sendEmail(email);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Email sent successfully");
        return ResponseEntity.ok(response);
    }
}
