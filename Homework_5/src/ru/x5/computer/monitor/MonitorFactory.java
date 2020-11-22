package ru.x5.computer.monitor;

import ru.x5.computer.component.Component;
import ru.x5.computer.component.ComponentFactory;

public class MonitorFactory implements ComponentFactory {
    @Override
    public Component createComponent(String typeMonitor) {
        TypeMonitor type = TypeMonitor.valueOf(typeMonitor.toUpperCase());
        Component monitor = null;
        switch (type) {
            case TN:
                monitor = new Monitor("LG", "TN", 24);
                break;
            case IPS:
                monitor = new Monitor("LG", "IPS", 24);
                break;
            default:
                throw new EnumConstantNotPresentException(TypeMonitor.class, type.name());

        }
        return monitor;
    }
}
