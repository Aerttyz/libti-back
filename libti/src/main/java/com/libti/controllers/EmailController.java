package com.libti.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.libti.dtos.EmailDTO;

@RestController
public class EmailController {
    
    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String to;

    @PostMapping("/contato")
    public String sendEmail(@RequestBody EmailDTO emailDTO) {
        // send email

        try {
            SimpleMailMessage msg = new SimpleMailMessage();
            msg.setFrom(emailDTO.getEmail());
            msg.setTo(to);
            msg.setSubject(emailDTO.getSubject());
            msg.setText("Nome: " + emailDTO.getName() + "\nEmail: " + emailDTO.getEmail() + "\nMensagem: " + emailDTO.getMessage());

            javaMailSender.send(msg);
            return "Email enviado com sucesso!";
            
        } catch (Exception e) {
            return "Erro ao enviar email!" + e.getMessage();
        }
    }
}
