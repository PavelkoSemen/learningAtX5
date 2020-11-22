package ru.x5.computer.ram;

import ru.x5.computer.component.Component;

public class Ram implements Component {
    private int RAMFrequency;
    private int memoryCount;
    private String typeMemory;
    private String manufacturer;

    public Ram(int RAMFrequency, int memoryCount, String typeMemory, String manufacturer) {
        this.RAMFrequency = RAMFrequency;
        this.memoryCount = memoryCount;
        this.typeMemory = typeMemory;
        this.manufacturer = manufacturer;
    }

    @Override
    public void start() {
        System.out.println("RAM start");
    }

    @Override
    public String getInfo() {
        return "Оперативная память " + this.manufacturer +
                ", размер " + this.memoryCount +
                ", частота " + this.RAMFrequency +
                ", тип памяти " + this.typeMemory
                ;
    }
}

