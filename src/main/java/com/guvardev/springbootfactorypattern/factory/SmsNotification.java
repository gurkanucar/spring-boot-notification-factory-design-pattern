package com.guvardev.springbootfactorypattern.factory;

import com.guvardev.springbootfactorypattern.model.BaseNotificationModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SmsNotification implements Notification<BaseNotificationModel> {

  @Override
  public void send(BaseNotificationModel notificationModel) {
    log.info("#SMS notif! {}", notificationModel.toString());
  }
}
