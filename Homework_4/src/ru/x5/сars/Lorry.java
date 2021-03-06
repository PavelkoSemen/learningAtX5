package ru.x5.сars;

public class Lorry extends Car {

    private double liftingCapacity;

    public Lorry() {
        super("KAMAZ-6520", "C", 33100, new Engine(235, "Cummins"));
        this.liftingCapacity = 20000;
    }

    public Lorry(String carModel, String carClass, double weight, double liftingCapacity, Engine motorType) {
        super(carModel, carClass, weight, motorType);
        this.liftingCapacity = liftingCapacity;
    }

    @Override
    public void start() {
        System.out.println("Грузовик поехал");
    }

    @Override
    public void stop() {
        System.out.println("Грузовик остановился");
    }

    @Override
    public void printInfo() {
        String info = super.basePrintInfo() + ", доп. параметры: " +
                " грузоподъемность - " + liftingCapacity;
        System.out.println(info);
    }

    public double getLiftingCapacity() {
        return liftingCapacity;
    }

    public void setLiftingCapacity(double liftingCapacity) {
        this.liftingCapacity = liftingCapacity;
    }
}

