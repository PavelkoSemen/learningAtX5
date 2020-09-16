package ru.x5.computer.graphicscard;

public class ActiveCooling implements StrategyCooling {
    @Override
    public String installCooling() {
        return "активное";
    }
}
