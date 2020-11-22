package ru.x5.computer.ram;

import ru.x5.computer.component.Component;
import ru.x5.computer.component.ComponentFactory;

public class RamFactory implements ComponentFactory {
    @Override
    public Component createComponent(String typeRam) {
        TypeRam type = TypeRam.valueOf(typeRam.toUpperCase());
        Component ramComponent = null;
        new Ram(10, 2048, "DDR4", "Samsung");
        switch (type) {
            case DDR4:
                ramComponent = new Ram(10, 2048, "DDR4", "Samsung");
                break;
            case DDR5:
                ramComponent = new Ram(10, 2048, "DDR5", "Samsung");
                break;
            default:
                throw new EnumConstantNotPresentException(TypeRam.class, type.name());
        }

        return ramComponent;
    }
}
