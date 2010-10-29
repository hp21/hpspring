package net.hp.st;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.channel.PollableChannel;
import org.springframework.integration.core.Message;
import org.springframework.integration.core.MessageChannel;
import org.springframework.integration.message.StringMessage;

public class ST1 {

  /**
   * @param args
   */
  public static void main(String[] args) {

    new ST1().run();
  }

  public void run() {

    ApplicationContext context = new ClassPathXmlApplicationContext("st1.xml");
    MessageChannel input = (MessageChannel) context.getBean("input");
    PollableChannel output = (PollableChannel) context.getBean("output");
    input.send(new StringMessage("Spring Integration rocks"));
    Message<?> reply = output.receive();
    System.out.println("received: " + reply.getPayload());
    
    System.out.println("input " + input.getClass().getName());
    System.out.println("output " + output.getClass().getName());

  }
}
