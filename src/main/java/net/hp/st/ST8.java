package net.hp.st;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.PollableChannel;

public class ST8 {

  /**
   * @param args
   */
  public static void main(String[] args) {
    new ST8().run();
  }

  public void run() {
    ApplicationContext context = new ClassPathXmlApplicationContext("st8.xml");

    System.out.println("Channel adapter: " + context.getBean("inboud-cheannel-adapter").getClass().getCanonicalName());
    /*
     * PollableChannel channel = context.getBean("channel",
     * PollableChannel.class); // channel.send(new StringMessage("Haho ocsi"));
     * 
     * System.out.println("channel=" + channel.getClass().getName());
     */

  }
}
