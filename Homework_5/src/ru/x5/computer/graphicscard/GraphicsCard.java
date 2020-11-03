package ru.x5.computer.graphicscard;

import ru.x5.computer.component.Component;

public abstract class GraphicsCard implements Component {
    private int memoryCount;
    private String typeMemory;
    private String manufacturer;

    public GraphicsCard(int memoryCount, String typeMemory, String manufacturer) {
        this.memoryCount = memoryCount;
        this.typeMemory = typeMemory;
        this.manufacturer = manufacturer;
    }

    public String baseCardInfo() {
        return this.manufacturer + ", количество памяти " +
                this.memoryCount + ", тип памяти " +
                this.typeMemory;
    }
}
