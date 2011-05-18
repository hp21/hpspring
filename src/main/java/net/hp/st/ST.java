package net.hp.st;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.LogFactoryImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.core.PollableChannel;
import org.springframework.integration.support.MessageBuilder;

public class ST {
  


  /**
   * @param args
   */
  public static void main(String[] args) {

    new ST().run();
  }

  public void run() {

    ApplicationContext context = new ClassPathXmlApplicationContext("st.xml");
    
    PollableChannel channel = (PollableChannel) context.getBean("channel");
    channel.send(MessageBuilder.withPayload("Spring Integration rocks").build());
    
    Message<?> reply = channel.receive();
    System.out.println("received: " + reply);
    System.out.println("received: " + reply.getPayload());

    for (int i = 0; i < 20; i++) {
      boolean b = channel.send(MessageBuilder.withPayload("MSG #" + i).build(), 10L);
      System.out.println("Result for #" + i + " = " + b);
    }

    for (int i = 0; i < 20; i++) {
      Message<?> msg = channel.receive();
      System.out.println(msg.getPayload());
    }

    System.out.println("channel name: " + channel.toString() + "/" + channel.getClass().getName());

    /*
     * reply = channel.receive(); System.out.println("received: " +
     * reply.getPayload());
     */

  }
}
