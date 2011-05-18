package net.hp.st;

import java.util.concurrent.atomic.AtomicInteger;

public class HPProducer {

  private AtomicInteger counter = new AtomicInteger(0);

  public String produce() {

    /*
     * try { Thread.sleep(1000); } catch (InterruptedException e) {
     * e.printStackTrace(); }
     */

    int value = counter.getAndIncrement();
    return value % 3 != 0 ? String.valueOf(value) : null;
  }

}
