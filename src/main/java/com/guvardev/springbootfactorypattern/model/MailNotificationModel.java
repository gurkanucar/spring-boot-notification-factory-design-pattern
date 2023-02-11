package com.guvardev.springbootfactorypattern.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MailNotificationModel extends BaseNotificationModel {

  private String mailSubject;
  private String mailBody;
  private String mailRecipient;
}
