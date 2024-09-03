package br.com.sendemail.services;

import br.com.sendemail.dtos.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaEmailSender;

    @Value("${spring.mail.username}")
    private String senderEmail;


    public String sendEmail(Email email) {
        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom(senderEmail);
            simpleMailMessage.setTo(email.email());
            // Construct the email body with name, phone, and message
            String emailBody = "Olá, o (a) " + email.name() + "!\n" +
                    "Do telefone: " + email.phone() + "\n\n" + "Enviou uma mensagem:" + "\n" +
                    email.message();
            simpleMailMessage.setSubject(email.subject());
            simpleMailMessage.setText(emailBody);
            javaEmailSender.send(simpleMailMessage);
            return "Email enviado com sucesso!";
        } catch (Exception e) {
            return "Erro ao enviar email: " + e.getMessage();
        }
    }

}
