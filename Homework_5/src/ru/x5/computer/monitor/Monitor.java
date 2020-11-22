package ru.x5.computer.monitor;

import ru.x5.computer.component.Component;

public class Monitor implements Component {
    private String manufacturer;
    private String screenMatrices;
    private int diagonal;

    public Monitor(String manufacturer, String screenMatrices, int diagonal) {
        this.manufacturer = manufacturer;
        this.screenMatrices = screenMatrices;
        this.diagonal = diagonal;
    }

    @Override
    public void start() {
        System.out.println("Monitor start");
    }

    @Override
    public String getInfo() {
        return "Монитор " + this.manufacturer +
                ", тип матрицы " + this.screenMatrices +
                ", диагональ " + this.diagonal;
    }
}
