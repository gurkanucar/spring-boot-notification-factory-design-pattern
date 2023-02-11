package com.guvardev.springbootfactorypattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.guvardev.springbootfactorypattern.factory.MailNotification;
import com.guvardev.springbootfactorypattern.factory.NotificationFactory;
import com.guvardev.springbootfactorypattern.factory.NotificationType;
import com.guvardev.springbootfactorypattern.factory.PushNotification;
import com.guvardev.springbootfactorypattern.factory.SmsNotification;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NotificationTest {

  @Autowired NotificationFactory notificationFactory;

  @Test
  void when_createPushNotificationFromFactory_should_returnNewInstance() {
    var actual = notificationFactory.create(NotificationType.PUSH_NOTIFICATION);
    assertEquals(PushNotification.class, actual.getClass());
  }

  @Test
  void when_createSmsNotificationFromFactory_should_returnNewInstance() {
    var actual = notificationFactory.create(NotificationType.SMS);
    assertEquals(SmsNotification.class, actual.getClass());
  }

  @Test
  void when_createMailNotificationFromFactory_should_returnNewInstance() {
    var actual = notificationFactory.create(NotificationType.MAIL);
    assertEquals(MailNotification.class, actual.getClass());
  }
}
