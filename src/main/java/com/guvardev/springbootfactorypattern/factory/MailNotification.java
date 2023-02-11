package com.guvardev.springbootfactorypattern.factory;

import com.guvardev.springbootfactorypattern.model.BaseNotificationModel;
import com.guvardev.springbootfactorypattern.model.MailModel;
import com.guvardev.springbootfactorypattern.model.MailNotificationModel;
import com.guvardev.springbootfactorypattern.service.MailSenderImpl;
import java.util.Collections;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MailNotification implements Notification<BaseNotificationModel> {

  private final MailSenderImpl mailSender;

  public MailNotification(MailSenderImpl mailSender) {
    this.mailSender = mailSender;
  }

  @Override
  public void send(BaseNotificationModel notificationModel) {
    var mailNotificationModel = ((MailNotificationModel) notificationModel);
    log.info("#Mail sender calling for notif! {}", notificationModel.toString());
    mailSender.sendMail(
        new MailModel(
            mailNotificationModel.getMailSubject(),
            mailNotificationModel.getMailBody(),
            Collections.singletonList(mailNotificationModel.getMailRecipient())));
  }

}
