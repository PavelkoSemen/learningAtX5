package ru.x5.сars;

public class Engine {
    private double power;
    private String manufacturer;

    public Engine(double power, String manufacturer) {
        this.power = power;
        this.manufacturer = manufacturer;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "двигатель [" +
                "мощность = " + power +
                ", производитель = " + manufacturer + "]";
    }
}
