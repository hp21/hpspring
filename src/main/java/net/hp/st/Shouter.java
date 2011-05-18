package net.hp.st;

import org.springframework.integration.Message;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.message.GenericMessage;


public class Shouter {

  @ServiceActivator
  public String shout(String s) {
    return s.concat("!!!");
  }

  public Message<String> shoutm(Message<String> s) {
    return new GenericMessage<String>(s.getPayload().toUpperCase().concat("!!! [message version]"));
  }
  
  public void shout3(Message<String> s) {
    System.out.println(s.getPayload().toUpperCase().concat("!!! [sohut3]"));
  }
  
  public void shout2() {
    System.out.println("shout2");
  }
}
