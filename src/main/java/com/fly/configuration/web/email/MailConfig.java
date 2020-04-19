package com.fly.configuration.web.email;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Objects;
import java.util.Properties;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties("mailconfig")
@Getter
@Setter
public class MailConfig {

  private String host;

  private String port;

  private String mailAddress;

  private String mailPassword;

  private String localServer;

  @Bean
  public JavaMailSender javaMailSender() {

    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

    mailSender.setHost(host);
    mailSender.setPort(Integer.valueOf(Objects.requireNonNull(port)));
    mailSender.setUsername(mailAddress);
    mailSender.setPassword(mailPassword);

    Properties properties = new Properties();

    properties.put("mail.transport.protocol", "smtp");
    properties.put("mail.smtp.auth", "true");
    properties.put("mail.smtp.starttls.enable", "true");
    properties.put("mail.debug", "true");

    mailSender.setJavaMailProperties(properties);

    return mailSender;
  }
}
