package net.hp.st;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

@MessageEndpoint
public class HPMessageEndpoint {

  private String name;

  @ServiceActivator(inputChannel = "channel")
  public void say(String str) {
    System.out.println(String.format("%s %s %s", name, "HP", str));
  }

  @Required
  public void setName(String name) {
    this.name = name;
  }
}
