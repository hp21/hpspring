package net.hp.st;

public class SquareString {

  public String square(String num) {
    System.out.println("Parameter: " + num);
    return String.valueOf(Integer.valueOf(num) * Integer.valueOf(num));
  }

}
