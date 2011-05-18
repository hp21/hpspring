package net.hp.st;

import java.util.concurrent.atomic.AtomicInteger;

public class HPProducer2 {

  private AtomicInteger counter = new AtomicInteger(0);

  public String produce() {

    int value = counter.getAndIncrement();
    System.out.println(String.format("%s called: %d times", this.getClass().getName(), value));
    
    return String.valueOf(value);
  }

}
