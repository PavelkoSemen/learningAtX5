package ru.x5.computer.graphicscard;

import ru.x5.computer.component.Component;
import ru.x5.computer.component.ComponentFactory;
import ru.x5.computer.storagedevice.TypeStorageDevice;

public class GraphicsCardFactory implements ComponentFactory {
    @Override
    public Component createComponent(String typeGraphicsCard) {
        TypeGraphicsCard type = TypeGraphicsCard.valueOf(typeGraphicsCard.toUpperCase());
        Component graphicsCardComponent = null;
        switch (type) {
            case DISCRETE:
                graphicsCardComponent = new DiscreteGraphicsCard();
                break;
            case INTEGRATED:
                graphicsCardComponent = new IntegratedGraphicsCard();
                break;
            default:
                throw new EnumConstantNotPresentException(TypeStorageDevice.class, type.name());
        }
        return graphicsCardComponent;
    }
}
