package ru.stqa.pft.sandbox;

public class Dist {

    public static void main(String[] args) {
        Point p1 = new Point(4, 11);
        Point p2 = new Point(2, 18);

        System.out.println("Расстояние между точками = " + p1.distance(p2));

    }
}
