package com.fly;

import com.fly.configuration.core.AppConfig;
import com.fly.repository.UserDAO;
import com.fly.repository.entities.User;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.security.auth.login.AppConfigurationEntry;

public class Main {
    public static void main(String[] args) {


    ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

    UserDAO userDAO = (UserDAO) context.getBean("userDAOimpl");
        for (User user: userDAO.findAll()) {
            System.out.println(user.toString());

        }

    }



}
