package ru.x5.сars;

public class SportCar extends Car {
    private int maxSpeed;

    public SportCar() {
        super("SF1000", "SportCar", 746, new Engine(1600, "Ferrari"));
        this.maxSpeed = 350;
    }

    public SportCar(String carModel, String carClass, double weight, int maxSpeed, Engine motorType) {
        super(carModel, carClass, weight, motorType);
        this.maxSpeed = maxSpeed;
    }

    @Override
    public void start() {
        System.out.println("SportCar поехал");
    }

    @Override
    public void stop() {
        System.out.println("SportCar остановился");
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public void printInfo() {
        System.out.println("Описание: класс - " + getCarClass() +
                ", модель - " + getCarModel() +
                ", вес - " + getWeight() +
                ", максимальная скорость - " + maxSpeed +
                ", " + getMotorType());
    }
}
