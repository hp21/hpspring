package net.hp.st;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.PollableChannel;

public class ST7 {

  /**
   * @param args
   */
  public static void main(String[] args) {
    new ST7().run();
  }

  public void run() {
    ApplicationContext context = new ClassPathXmlApplicationContext("st7.xml");

    PollableChannel channel = context.getBean("channel", PollableChannel.class);
    // channel.send(new StringMessage("Haho ocsi"));

    System.out.println("channel=" + channel.getClass().getName());

  }
}
