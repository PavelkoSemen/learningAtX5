package ru.x5.computer.graphicscard;

public class IntegratedGraphicsCardFactory implements GraphicsCardFactory {
    @Override
    public GraphicsCard createGraphicsCard() {
        return new IntegratedGraphicsCard();
    }
}
