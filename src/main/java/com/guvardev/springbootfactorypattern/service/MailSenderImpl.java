package com.guvardev.springbootfactorypattern.service;

import com.guvardev.springbootfactorypattern.model.MailModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MailSenderImpl implements MailSender {

  @Override
  public void sendMail(MailModel mailModel) {
    log.info("#mail sender impl {}", mailModel.toString());
  }
}
