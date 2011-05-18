package net.hp.st;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.channel.DirectChannel;

public class ST5 {

  /**
   * @param args
   */
  public static void main(String[] args) {
    new ST5().run();
  }

  public void run() {
    ApplicationContext context = new ClassPathXmlApplicationContext("st5.xml");

    DirectChannel channel = context.getBean("channel", DirectChannel.class);
    // channel.send(new StringMessage("Haho ocsi"));

    System.out.println("channel=" + channel.getClass().getName());

  }
}
