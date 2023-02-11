package com.guvardev.springbootfactorypattern.service;


import com.guvardev.springbootfactorypattern.model.MailModel;

public interface MailSender {

  void sendMail(MailModel mailModel);

}
