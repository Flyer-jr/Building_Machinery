package com.fly.service.mail;

import com.fly.configuration.web.email.MailConfig;
import com.fly.repository.entities.Order;
import com.fly.repository.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailMessageCreator {

  private final MailConfig config;

  private static final String CONFIRMATION_TEXT =
          "Hello! \n "
                  + "You are trying to register in Building Machinery.\n "
                  + "Please confirm your E-mail address by clicking the link below: \n";

  private static final String REGISTRATION_TEXT =
          "Hello! \n "
                  + "You've been successfully registered to Building Machinery application. \n "
                  + "Your login: ";
  private static final String ORDER_TEXT =
          "Hello! \n " + "You have just created an order, that includes: ";
  private static final String PREFIX = "http://";
  private static final String DELIMITER = ": ";

  public String confirmationMessageCreate(String confirmationToken) {

    String message = "";
    message =
            message.concat(CONFIRMATION_TEXT)
                    .concat(config.getLocalServer())
                    .concat(confirmationToken);

    return message;
  }

  public String registrationMessageCreate(User user) {

    String message = "";
    message = message.concat(REGISTRATION_TEXT).concat(user.toString());

    return message;
  }

  public String orderMessageCreate(User user, Order order) {
    String message = "";
    message =
            message
                    .concat(ORDER_TEXT)
                    .concat(
                            String.format(
                                    "User %s %s just created new order \n "
                                            + " it includes: \n %s \n "
                                            + " for the site: \n %s \n "
                                            + " with some conflicts: %s.",
                                    user.getFirstName(),
                                    user.getSecondName(),
                                    order.getEquipment(),
                                    order.getConstructionSite(),
                                    order.getConflict()));
    return message;
  }
}
