package com.ms.email.service;

import com.ms.email.enums.EmailStatus;
import com.ms.email.model.Email;
import com.ms.email.repository.EmailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final EmailRepository emailRepository;
    private final JavaMailSender emailSender;

    @Value(value = "${spring.mail.username}")
    private String emailFrom;

    public Email sendEmail(Email email) {
        email.setSendDateEmail(LocalDateTime.now());
        email.setEmailFrom(emailFrom);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email.getEmailTo());
        message.setSubject(email.getSubject());
        message.setText(email.getText());

        try {
            emailSender.send(message);
            email.setStatusEmail(EmailStatus.SUCCESS);
        } catch (MailException e) {
            email.setStatusEmail(EmailStatus.ERROR);
        }
        return emailRepository.save(email);
    }
}
