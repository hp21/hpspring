package net.hp.st;

import org.springframework.integration.core.Message;
import org.springframework.integration.message.MessageDeliveryException;
import org.springframework.integration.message.MessageHandler;
import org.springframework.integration.message.MessageHandlingException;
import org.springframework.integration.message.MessageRejectedException;

public class HPConsumer implements MessageHandler {

  @Override
  public void handleMessage(Message<?> message) throws MessageRejectedException, MessageHandlingException,
      MessageDeliveryException {

    System.out.println(this.getClass().getName() + " " + message.getPayload());

  }

}
