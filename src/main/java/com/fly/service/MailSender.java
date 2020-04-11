package com.fly.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;


@Service
@RequiredArgsConstructor
public class MailSender {
    private static final String SUBJECT = "Building Machinery User Registration Confirmation";
    private static final String TEXT = "Hello! You are trying to register in Building Machinery.\n Please confirm " +
            "your E-mail address by clicking the link below:";

    private final JavaMailSender javaMailSender;




    public void sendMail(String emailAddress){
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        try {
                helper.setTo(emailAddress);
                helper.setSubject(SUBJECT);
                helper.setText(TEXT);
                this.javaMailSender.send(message);
            } catch (javax.mail.MessagingException messageException) {
                throw new RuntimeException(messageException);
            }
        }

    }
