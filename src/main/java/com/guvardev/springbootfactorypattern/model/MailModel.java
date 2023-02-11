package com.guvardev.springbootfactorypattern.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailModel {

  private String subject;
  private String body;
  private List<String> receiver;
}
