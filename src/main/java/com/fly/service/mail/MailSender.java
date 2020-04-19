package com.fly.service.mail;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;


@Service
@RequiredArgsConstructor
public class MailSender {
    private static final String SUBJECT = "Building Machinery User Registration Confirmation";


    private final JavaMailSender javaMailSender;

    @Async
    public void sendMail(String emailAddress, String message) {
        MimeMessage mailMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mailMessage);

        try {
            helper.setTo(emailAddress);
            helper.setSubject(SUBJECT);
            helper.setText(message);
            this.javaMailSender.send(mailMessage);
        } catch (javax.mail.MessagingException messageException) {
            throw new RuntimeException(messageException);
        }
    }

    }
