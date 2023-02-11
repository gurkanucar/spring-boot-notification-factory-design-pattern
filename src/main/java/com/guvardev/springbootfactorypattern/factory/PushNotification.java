package com.guvardev.springbootfactorypattern.factory;

import com.guvardev.springbootfactorypattern.model.BaseNotificationModel;
import com.guvardev.springbootfactorypattern.model.PushNotificationModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PushNotification implements Notification<BaseNotificationModel> {

  @Override
  public void send(BaseNotificationModel notificationModel) {
    log.info(
        "#Push notif! deviceId: {}", ((PushNotificationModel) notificationModel).getDeviceId());
  }
}
