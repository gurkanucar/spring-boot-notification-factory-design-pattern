package com.guvardev.springbootfactorypattern.factory;

import com.guvardev.springbootfactorypattern.model.BaseNotificationModel;

public interface Notification<T extends BaseNotificationModel> {
  void send(BaseNotificationModel notificationModel);
}
