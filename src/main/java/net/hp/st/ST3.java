package net.hp.st;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.ExecutorChannel;
import org.springframework.integration.core.Message;
import org.springframework.integration.message.MessageDeliveryException;
import org.springframework.integration.message.MessageHandler;
import org.springframework.integration.message.MessageHandlingException;
import org.springframework.integration.message.MessageRejectedException;
import org.springframework.integration.message.StringMessage;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

public class ST3 {

  /**
   * @param args
   */
  public static void main(String[] args) {

    // new ST3().run();
    new ST3().run1();
  }

  private void run1() {

    ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
    taskExecutor.setCorePoolSize(3);
    taskExecutor.setMaxPoolSize(5);
    taskExecutor.setQueueCapacity(11111);
    taskExecutor.initialize();

    ExecutorChannel channel = new ExecutorChannel(taskExecutor);
    channel.subscribe(new MessageHandler() {

      @Override
      public void handleMessage(Message<?> message) throws MessageRejectedException, MessageHandlingException,
          MessageDeliveryException {
        System.out.println("Handler msg- " + message.getPayload());

      }
    });

    for (int i = 0; i < 20; i++) {
      if (i % 3 == 0) {
        try {
          Thread.sleep(350, 0);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      System.out.println("*** Sending " + i);
      channel.send(new StringMessage("MESSAGE BODY " + i));
    }

  }

  public void run() {

    DirectChannel channel = new DirectChannel();
    MessageHandler handler = new MessageHandler() {

      @Override
      public void handleMessage(Message<?> message) throws MessageRejectedException, MessageHandlingException,
          MessageDeliveryException {
        System.out.println("handler  " + message.getPayload());
      }
    };

    channel.subscribe(handler);

    channel.send(new StringMessage("MESSAGE BODY"));

    for (int i = 0; i < 20; i++) {
      if (i % 3 == 0) {
        try {
          Thread.sleep(350, 0);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      channel.send(new StringMessage("MESSAGE BODY " + i));
    }

  }

}
