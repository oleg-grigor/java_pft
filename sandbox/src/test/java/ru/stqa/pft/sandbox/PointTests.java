package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

  @Test
public void testDistance1 () {
    Point p1 = new Point(1, 10);
    Point p2 = new Point(1, 9);

    Assert.assertEquals(p1.distance(p2), 1);
  }
  @Test
  public void testDistance2 () {
    Point p1 = new Point(2, 11);
    Point p2 = new Point(2, 15);

    Assert.assertEquals(p1.distance(p2), 4);
  }

  @Test
  public void testDistance3 () {
    Point p1 = new Point(2, 11);
    Point p2 = new Point(2, 15);

    Assert.assertEquals(p1.distance(p2), 4);
  }
}
