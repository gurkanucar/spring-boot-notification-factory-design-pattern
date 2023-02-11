package com.guvardev.springbootfactorypattern.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SmsNotificationModel extends BaseNotificationModel {
  private String messageContent;
  private String phoneNumber;
}
