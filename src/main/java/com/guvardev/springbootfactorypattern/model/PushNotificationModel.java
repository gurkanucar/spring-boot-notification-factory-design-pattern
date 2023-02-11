package com.guvardev.springbootfactorypattern.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PushNotificationModel extends BaseNotificationModel {
  private String deviceId;
  private String content;
}
