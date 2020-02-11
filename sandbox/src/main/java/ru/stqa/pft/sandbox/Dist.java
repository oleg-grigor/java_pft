package ru.stqa.pft.sandbox;

public class Dist {

    public static void main(String[] args) {
        Point p1 = new Point(2, 5);
        Point p2 = new Point(1, 9);

        System.out.println("Расстояние между точками = " + p2.distance(p1, p2));

    }
}
