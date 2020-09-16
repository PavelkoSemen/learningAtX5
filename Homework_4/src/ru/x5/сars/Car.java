package ru.x5.сars;

public abstract class Car {
    private String carModel;
    private String carClass;
    private double weight;
    private Engine motorType;

    public Car(String carModel, String carClass, double weight, Engine motorType) {
        this.carModel = carModel;
        this.carClass = carClass;
        this.weight = weight;
        this.motorType = motorType;
    }

    public void turnRight() {
        System.out.println("Поворот направо");
    }

    public void turnLeft() {
        System.out.println("Поворот налево");
    }

    public abstract void start();

    public abstract void stop();

    public abstract void printInfo();

    public String basePrintInfo() {
        return "Описание: класс - " + carClass +
                ", модель - " + carModel +
                ", вес - " + weight +
                ", " + motorType.toString();
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarClass() {
        return carClass;
    }

    public void setCarClass(String carClass) {
        this.carClass = carClass;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Engine getMotorType() {
        return motorType;
    }

    public void setMotorType(Engine motorType) {
        this.motorType = motorType;
    }
}
