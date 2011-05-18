package net.hp.st;

import org.springframework.integration.Message;
import org.springframework.integration.MessagingException;
import org.springframework.integration.core.MessageHandler;

public class HPMessageHandler implements MessageHandler {

  private String handlerName;

  public HPMessageHandler() {
  }

  @Override
  public void handleMessage(Message<?> message) throws MessagingException {
    System.out.println(String.format("Handler: %s handling message: %s", handlerName, message));
  }

  public String getHandlerName() {
    return handlerName;
  }

  public void setHandlerName(String handlerName) {
    this.handlerName = handlerName;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("HPMessageHandler [handlerName=").append(handlerName).append("]");
    return builder.toString();
  }

}
