package net.hp.st;

import org.springframework.integration.Message;
import org.springframework.integration.MessageDeliveryException;
import org.springframework.integration.MessageHandlingException;
import org.springframework.integration.MessageRejectedException;
import org.springframework.integration.core.MessageHandler;

public class HPConsumer implements MessageHandler {

  @Override
  public void handleMessage(Message<?> message) throws MessageRejectedException, MessageHandlingException,
      MessageDeliveryException {

    System.out.println(this.getClass().getName() + " " + message.getPayload());

  }

}
