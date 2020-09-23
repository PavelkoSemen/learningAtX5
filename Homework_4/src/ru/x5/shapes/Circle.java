package ru.x5.shapes;

public class Circle implements Shape {
    // PI можно так же взять из Math
    private double radius;

    public Circle() {
        this(1);
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double square() {
        return Math.PI * Math.pow(radius, 2);
    }
}
