package ru.x5.computer.computer;

import ru.x5.computer.component.Component;
import ru.x5.computer.cpu.CPUImpl;
import ru.x5.computer.graphicscard.GraphicsCard;
import ru.x5.computer.graphicscard.GraphicsCardFactory;
import ru.x5.computer.graphicscard.TypeGraphicsCard;
import ru.x5.computer.monitor.MonitorImpl;
import ru.x5.computer.ram.RAMImpl;
import ru.x5.computer.storagedevice.SSD;
import ru.x5.computer.storagedevice.StorageDevice;
import ru.x5.computer.storagedevice.StorageDeviceFactory;
import ru.x5.computer.storagedevice.TypeStorageDevice;


public class GamingComputer implements ComputerStrategy {
    @Override
    public Computer build() {
        Component cpu = new CPUImpl.Builder("AMD", "Ryzen 7")
                .numberOfCores(8)
                .clockFrequency(7)
                .cash(1028)
                .build();
        Component ram = new RAMImpl.Builder("Samsung")
                .memoryCount(2048)
                .typeMemory("DDR 5")
                .RAMFrequency(7)
                .build();
        Component monitor = new MonitorImpl.Builder("LG")
                .screenMatrices("VA")
                .diagonal(24)
                .build();
        Component graphicsCard = new GraphicsCardFactory().createComponent(TypeGraphicsCard.DISCRETE);
        Component storageDevice = new StorageDeviceFactory().createComponent(TypeStorageDevice.SSD);

        return new Computer.Builder()
                .computerGraphicsCard(graphicsCard)
                .computerStorageDevice(storageDevice)
                .computerRAM(ram)
                .CPUComputer(cpu)
                .computerMonitor(monitor)
                .build();

    }
}
