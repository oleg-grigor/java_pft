package ru.stqa.pft.sandbox;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class Dist {

  public static void main(String[] args) {
    Point p1 = new Point();
    Point p2 = new Point();
    p1.x = 2;
    p1.y = 5;
    p2.x = 1;
    p2.y = 9;

    System.out.println(distance(p1,p2));

  }

  public static double distance(Point p1, Point p2) {
    return Math.sqrt((p2.x-p1.x)*(p2.x-p1.x)+(p2.y-p1.y)*(p2.y-p1.y));
  }


}
