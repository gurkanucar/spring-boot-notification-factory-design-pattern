# Factory design pattern using spring-boot - Notification Factory example

#### NotificationFactory Class (must be Component or Service if you want to inject some dependencies to Classes that are implementing Notification interface)

```java
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
```



#### Notification Interface

```java
public interface Notification<T extends BaseNotificationModel> {
  void send(BaseNotificationModel notificationModel);
}

```

#### Example Usage

```java
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
    
    

    //mailSender is also called from within the MailNotification class
    notificationFactory
        .create(NotificationType.MAIL)
        .send(new MailNotificationModel("subject1", "receiver", "recipient1"));

    mailSender.sendMail(
        new MailModel("subject2", "body2",
            List.of("recipient1", "recipient2", "recipient3")));
  }
}

```
