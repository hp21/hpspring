package net.hp.st;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ST9 {

  /**
   * @param args
   */
  public static void main(String[] args) {
    new ST9().run();
  }

  public void run() {
    ApplicationContext context = new ClassPathXmlApplicationContext("st9.xml");

    ISquare service = context.getBean("gw", ISquare.class);

    for (int i = 0; i < 12; i++) {
      int value = service.square(i);
      System.out.println("Value: " + value);
    }
  }
}
