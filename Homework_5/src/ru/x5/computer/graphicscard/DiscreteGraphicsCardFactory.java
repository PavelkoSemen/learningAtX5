package ru.x5.computer.graphicscard;

public class DiscreteGraphicsCardFactory implements GraphicsCardFactory {
    @Override
    public GraphicsCard createGraphicsCard() {
        return new DiscreteGraphicsCard();
    }
}
