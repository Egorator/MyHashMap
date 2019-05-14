package test.home.yehor;

import home.yehor.Logic.*;
import org.junit.Test;
import java.util.Random;

import static org.junit.Assert.*;

public class TestMyHashMap {

  @Test
  public void basicTest() {
    HashMap hashMap = new HashMap(11);
    hashMap.put(7, 235);
    hashMap.put(36, 5437);
    hashMap.put(18, 34);
    hashMap.put(62, 6759);
    hashMap.put(5, 364);
    assertEquals(hashMap.get(7), new Long(235));
    assertEquals(hashMap.get(36), new Long(5437));
    assertEquals(hashMap.get(18), new Long(34));
    assertEquals(hashMap.get(62), new Long(6759));
    assertEquals(hashMap.get(5), new Long(364));
  }

  @Test(expected = IllegalArgumentException.class)
  public void zeroCapacityHashMapTest() {
    new HashMap(0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void negativeCapacityHashMapTest() {
    new HashMap(-3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void tooBigCapacityHashMapTest() {
    new HashMap(Integer.MAX_VALUE);
  }

  @Test
  public void getReturnsNullValueTest() {
    HashMap hashMap = new HashMap(11);
    hashMap.put(7, 235);
    assertNull(hashMap.get(2));
  }

  @Test
  public void sizeTest() {
    HashMap hashMap = new HashMap(11);
    hashMap.put(7, 235);
    hashMap.put(5, 25);
    hashMap.put(52, 13);
    hashMap.put(124, 52);
    hashMap.put(74, 23);
    hashMap.put(123, 253);
    assertEquals(hashMap.size(), 6);
  }

  @Test
  public void rehashingTest() {
    HashMap hashMap = new HashMap(4);
    hashMap.put(7, 235);
    hashMap.put(5, 25);
    hashMap.put(52, 13);
    hashMap.put(123, 41);
    assertEquals(hashMap.size(), 4);
    assertEquals(hashMap.getCapacity(), 8);
  }

  @Test
  public void putReturnsPreviousValueTest() {
    HashMap hashMap = new HashMap(4);
    hashMap.put(7, 235);
    assertEquals(hashMap.put(7, 14), new Long(235));
  }

  @Test
  public void stressTest() {
    HashMap hashMap = new HashMap(1);
    Random r = new Random();
    try {
      for (int i = 0; i < 711720956 / 50; i++) { // Maximal allowed value is divided by 50 because this test
        // takes some time to execute
        int randomKey = r.nextInt(Integer.MAX_VALUE);
        hashMap.put(randomKey, r.nextLong());
        assertNotNull(hashMap.get(randomKey));
      }
      int a = hashMap.size();
      int b = hashMap.getCapacity();
    } catch (Exception e) {
      fail();
    }
  }
}

