package ru.x5.computer.cpu;

import ru.x5.computer.component.Component;

public class Cpu implements Component {
    private int clockFrequency;
    private int numberOfCores;
    private int cash;
    private String name;
    private String manufacturer;

    public Cpu(int clockFrequency, int numberOfCores, int cash, String name, String manufacturer) {
        this.clockFrequency = clockFrequency;
        this.numberOfCores = numberOfCores;
        this.cash = cash;
        this.name = name;
        this.manufacturer = manufacturer;
    }


    @Override
    public void start() {
        System.out.println("CPU start");
    }

    @Override
    public String getInfo() {
        return "Процессор " + this.manufacturer +
                ", название " + this.name +
                ", частота " + this.clockFrequency +
                ", количество ядер " + this.numberOfCores +
                ", кэш " + this.cash;
    }


}

