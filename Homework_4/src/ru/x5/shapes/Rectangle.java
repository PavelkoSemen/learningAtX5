package ru.x5.shapes;

public class Rectangle implements Shape {
    private double height;
    private double width;

    public Rectangle() {
        this(1, 1);
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double square() {
        return width * height;
    }
}
