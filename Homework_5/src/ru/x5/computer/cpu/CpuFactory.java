package ru.x5.computer.cpu;


import ru.x5.computer.component.Component;
import ru.x5.computer.component.ComponentFactory;

public class CpuFactory implements ComponentFactory {
    @Override
    public Component createComponent(String typeCpu) {
        TypeCpu type = TypeCpu.valueOf(typeCpu.toUpperCase());
        Component cpuComponent = null;
        switch (type) {
            case GAME:
                cpuComponent = new Cpu(7, 8, 1028, "Ryzen 7", "AMD");
                break;
            case SERVER:
                cpuComponent = new Cpu(14, 2, 1028, "Core i5", "Intel");
                break;
            default:
                throw new EnumConstantNotPresentException(TypeCpu.class, type.name());

        }

        return cpuComponent;
    }
}
