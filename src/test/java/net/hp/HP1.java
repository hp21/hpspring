package net.hp;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hp.test.AddMult;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class HP1 {

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
  }

  private AddMult service;

  @Before
  public void setUp() throws Exception {
    service = new AddMult();
  }

  @Test
  public void testEval() {

    List<String> inList = new ArrayList<String>();
    int result = service.eval(inList);
    assertTrue(0 == result);

    inList = Arrays.asList("1");
    result = service.eval(inList);
    assertTrue(1 == result);

    inList = Arrays.asList("1", "2", "3");
    result = service.eval(inList);
    assertTrue(6 == result);

    inList = Arrays.asList("[", "1", "2", "3", "]");
    result = service.eval(inList);
    assertTrue(0 == result);

    inList = Arrays.asList("9", "[", "1", "2", "3", "]");
    result = service.eval(inList);
    assertTrue(54 == result);

    inList = Arrays.asList("1", "[", "2", "3", "]", "11");
    result = service.eval(inList);
    assertTrue(16 == result);

    inList = Arrays.asList("1", "[", "2", "]", "[", "3", "4", "]");
    result = service.eval(inList);
    assertTrue(14 == result);

    inList = Arrays.asList("1", "[", "2", "[", "20", "30", "]", "]", "[", "3", "4", "]");
    result = service.eval(inList);
    assertTrue(700 == result);

    inList = Arrays.asList("1", "[", "2", "[", "20", "30", "]", "]", "[", "3", "4", "]", "123");
    result = service.eval(inList);
    assertTrue(823 == result);
  }

}
