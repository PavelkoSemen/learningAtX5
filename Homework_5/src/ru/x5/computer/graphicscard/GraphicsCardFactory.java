package ru.x5.computer.graphicscard;

import ru.x5.computer.component.Component;
import ru.x5.computer.component.ComponentFactory;

public class GraphicsCardFactory implements ComponentFactory<TypeGraphicsCard> {
    @Override
    public Component createComponent(TypeGraphicsCard typeGraphicsCard) {
        Component graphicsCardComponent = null;
        switch (typeGraphicsCard) {
            case DISCRETE:
                graphicsCardComponent = new DiscreteGraphicsCard();
                break;
            case INTEGRATED:
                graphicsCardComponent = new IntegratedGraphicsCard();
                break;
            default:
                throw new IllegalArgumentException("Несуществующий тип карты");
        }
        return graphicsCardComponent;
    }
}
