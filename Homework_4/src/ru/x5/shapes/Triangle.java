package ru.x5.shapes;

public class Triangle implements Shape {
    private double base;
    private double height;

    public Triangle() {
        this(1, 1);
    }

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double square() {
        return 0.5 * base * height;
    }
}
