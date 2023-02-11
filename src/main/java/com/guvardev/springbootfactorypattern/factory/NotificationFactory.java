package com.guvardev.springbootfactorypattern.factory;

import com.guvardev.springbootfactorypattern.model.BaseNotificationModel;
import com.guvardev.springbootfactorypattern.service.MailSenderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificationFactory<T> {

  private final MailSenderImpl mailSender;

  @Autowired
  public NotificationFactory(MailSenderImpl mailSender) {
    this.mailSender = mailSender;
  }

  public Notification<BaseNotificationModel> create(NotificationType type) {
    return switch (type) {
      case SMS -> new SmsNotification();
      case MAIL -> new MailNotification(mailSender);
      case PUSH_NOTIFICATION -> new PushNotification();
      default -> throw new IllegalArgumentException("Unknown type");
    };
  }
}
