package com.guvardev.springbootfactorypattern.factory;

public enum NotificationType {

  MAIL("MAIL"),SMS("SMS"),PUSH_NOTIFICATION("PUSH");

  String key;

   NotificationType(String type){
    this.key=type;
  }

}
