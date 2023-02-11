package com.guvardev.springbootfactorypattern;

import com.guvardev.springbootfactorypattern.factory.NotificationFactory;
import com.guvardev.springbootfactorypattern.factory.NotificationType;
import com.guvardev.springbootfactorypattern.model.MailModel;
import com.guvardev.springbootfactorypattern.model.MailNotificationModel;
import com.guvardev.springbootfactorypattern.model.PushNotificationModel;
import com.guvardev.springbootfactorypattern.model.SmsNotificationModel;
import com.guvardev.springbootfactorypattern.service.MailSender;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Startup implements CommandLineRunner {

  private final MailSender mailSender;

  private final NotificationFactory notificationFactory;

  public Startup(MailSender mailSender, NotificationFactory notificationFactory) {
    this.mailSender = mailSender;
    this.notificationFactory = notificationFactory;
  }

  @Override
  public void run(String... args) throws Exception {
    notificationFactory
        .create(NotificationType.SMS)
        .send(new SmsNotificationModel("message content1", "+123456789"));

    notificationFactory
        .create(NotificationType.PUSH_NOTIFICATION)
        .send(new PushNotificationModel("device123", "push1"));

    notificationFactory
        .create(NotificationType.MAIL)
        .send(new MailNotificationModel("subject1", "receiver", "recipient1"));

    mailSender.sendMail(
        new MailModel("subject2", "body2", List.of("recipient1", "recipient2", "recipient3")));
  }
}
