package net.hp.st;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.channel.PollableChannel;
import org.springframework.integration.core.Message;
import org.springframework.integration.message.StringMessage;

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
    channel.send(new StringMessage("Spring Integration rocks"));
    Message<?> reply = channel.receive();
    System.out.println("received: " + reply);
    System.out.println("received: " + reply.getPayload());

    for (int i = 0; i < 20; i++) {
      boolean b = channel.send(new StringMessage("MSG #" + i), 10L);
      System.out.println("Result for #" + i + " = " + b);
    }

    for (int i = 0; i < 10; i++) {
      Message<?> msg = channel.receive();
      System.out.println(msg.getPayload());
    }

    System.out.println("channel name: " + channel.getName() + "/" + channel.getClass().getName());

    /*
     * reply = channel.receive(); System.out.println("received: " +
     * reply.getPayload());
     */

  }
}
