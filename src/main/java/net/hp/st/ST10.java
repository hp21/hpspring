package net.hp.st;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ST10 {

  /**
   * @param args
   */
  public static void main(String[] args) {
    new ST10().run();
  }

  public void run() {
    ApplicationContext context = new ClassPathXmlApplicationContext("st10.xml");
    System.out.println(context.getBean("file-input").getClass().getName());
  }

}
