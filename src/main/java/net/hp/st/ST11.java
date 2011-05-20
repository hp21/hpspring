package net.hp.st;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ST11 {

  /**
   * @param args
   */
  public static void main(String[] args) {
    new ST11().run();
  }

  public void run() {
    ApplicationContext context = new ClassPathXmlApplicationContext("st11.xml");

    System.out.println("feed adapter: " + context.getBean("input-feed-adapter").getClass().getCanonicalName());
    // System.out.println(context.getBean("file-input").getClass().getName());
  }

}
