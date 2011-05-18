package net.hp.st;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.MessageDeliveryException;
import org.springframework.integration.MessageHandlingException;
import org.springframework.integration.MessageRejectedException;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageHandler;
import org.springframework.integration.core.SubscribableChannel;

public class ST4 {

  /**
   * @param args
   */
  public static void main(String[] args) {
    new ST4().run();
  }

  public void run() {
    ApplicationContext context = new ClassPathXmlApplicationContext("st4.xml");

    SubscribableChannel channel = context.getBean("channel", DirectChannel.class);
    // SubscribableChannel channel =
    // context.getBean("publish-subscribe-channel1", SubscribableChannel.class);
    // channel.send(new StringMessage("Haho ocsi"));

    System.out.println("channel=" + channel.getClass().getName());

    channel.subscribe(new MessageHandler() {

      @Override
      public void handleMessage(Message<?> message) throws MessageRejectedException, MessageHandlingException,
          MessageDeliveryException {
        System.out.println("Handler1 msg: " + message.getPayload());

      }
    });

    channel.subscribe(new MessageHandler() {

      @Override
      public void handleMessage(Message<?> message) throws MessageRejectedException, MessageHandlingException,
          MessageDeliveryException {
        System.out.println("Handler2 msg: " + message.getPayload());

      }
    });

  }
}
