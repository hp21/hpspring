package net.hp.st;

import org.springframework.integration.core.Message;
import org.springframework.integration.message.StringMessage;

public class Shouter {

  public String shout(String s) {
    return s.toUpperCase().concat("!!!");
  }

  public Message<String> shoutm(Message<String> s) {
    return new StringMessage(s.getPayload().toUpperCase().concat("!!! [message version]"));
  }
  
  public void shout3(Message<String> s) {
    System.out.println(s.getPayload().toUpperCase().concat("!!! [sohut3]"));
  }
  
  public void shout2() {
    System.out.println("shout2");
  }
}
