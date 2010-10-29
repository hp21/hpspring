package net.hp.st;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.Message;
import org.springframework.integration.core.MessageChannel;
import org.springframework.integration.message.MessageDeliveryException;
import org.springframework.integration.message.MessageHandler;
import org.springframework.integration.message.MessageHandlingException;
import org.springframework.integration.message.MessageRejectedException;

public class ST4 {

  /**
   * @param args
   */
  public static void main(String[] args) {
    new ST4().run();
  }

  public void run() {
    ApplicationContext context = new ClassPathXmlApplicationContext("st4.xml");

    DirectChannel channel = context.getBean("channel", DirectChannel.class);
    // channel.send(new StringMessage("Haho ocsi"));

    System.out.println("channel=" + channel.getClass().getName());

    channel.subscribe(new MessageHandler() {

      @Override
      public void handleMessage(Message<?> message) throws MessageRejectedException, MessageHandlingException,
          MessageDeliveryException {
        System.out.println("Handler msg: " + message.getPayload());

      }
    });

  }
}
