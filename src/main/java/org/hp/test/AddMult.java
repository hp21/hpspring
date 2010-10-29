package org.hp.test;

import java.util.Arrays;
import java.util.List;

public class AddMult {

  int index = 0;

  public static void main(String[] args) {
    new AddMult().run();
  }

  private void run() {

    String str = "1,2,3,[,4,5,]";

    int result = evalString(str);

    System.out.println(String.format("Result = %d", result));

  }

  private int evalString(String str) {
    index = 0;
    List<String> inList = Arrays.asList(str.split(" |,"));
    int res = eval(inList);
    return res;
  }

  public int eval1(List<String> inList, int start) {
    int sum = 0;

    while (index < inList.size()) {
      String str = inList.get(index);
      if (isDigit(str)) {
        Integer val = Integer.valueOf(str);
        sum = sum + val;
      } else if ("[".equals(str)) {
        sum = sum * eval1(inList, index++);
      } else if ("]".equals(str)) {
        return sum;
      } else {
        throw new RuntimeException(String.format("Illegal input found: %s, %s", inList, str));
      }

      index++;
    }

    return sum;

  }

  public int eval(List<String> inList) {

    index = 0;
    return eval1(inList, 0);
  }

  private boolean isDigit(String str) {
    return str.matches("[0-9]+");
  }

}
