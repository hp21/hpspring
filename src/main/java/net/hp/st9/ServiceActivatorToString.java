package net.hp.st9;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

@Component
public class ServiceActivatorToString {

  public ServiceActivatorToString() {

  }

  @ServiceActivator
  public void log(Object obj) {
    System.out.println("Class: " + obj.getClass().getCanonicalName());
    System.out.println(obj.toString());
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("ServiceActivatorToString [getClass()=").append(getClass()).append(", hashCode()=").append(hashCode())
        .append(", toString()=").append(super.toString()).append("]");
    return builder.toString();
  }

}
