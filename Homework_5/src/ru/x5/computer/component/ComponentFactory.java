package ru.x5.computer.component;

import ru.x5.computer.component.Component;

public interface ComponentFactory {
    public Component createComponent(String type);
}