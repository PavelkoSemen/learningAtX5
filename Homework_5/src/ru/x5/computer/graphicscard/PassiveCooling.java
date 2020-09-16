package ru.x5.computer.graphicscard;

public class PassiveCooling implements StrategyCooling {
    @Override
    public String installCooling() {
        return "пассивное";
    }
}
