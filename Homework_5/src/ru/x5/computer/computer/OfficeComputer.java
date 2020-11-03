package ru.x5.computer.computer;

import ru.x5.computer.component.Component;
import ru.x5.computer.cpu.CPUImpl;
import ru.x5.computer.graphicscard.GraphicsCardFactory;
import ru.x5.computer.graphicscard.TypeGraphicsCard;
import ru.x5.computer.monitor.MonitorImpl;
import ru.x5.computer.ram.RAMImpl;
import ru.x5.computer.storagedevice.StorageDeviceFactory;
import ru.x5.computer.storagedevice.TypeStorageDevice;

public class OfficeComputer implements ComputerStrategy {
    @Override
    public Computer build() {
        Component cpu = new CPUImpl.Builder("Intel", "core i5")
                .numberOfCores(2)
                .clockFrequency(14)
                .cash(1028)
                .build();
        Component ram = new RAMImpl.Builder("Samsung")
                .memoryCount(2048)
                .typeMemory("DDR 2")
                .RAMFrequency(14)
                .build();
        Component monitor = new MonitorImpl.Builder("LG")
                .screenMatrices("IPS")
                .diagonal(24)
                .build();
        Component graphicsCard = new GraphicsCardFactory().createComponent(TypeGraphicsCard.INTEGRATED);
        Component storageDevice = new StorageDeviceFactory().createComponent(TypeStorageDevice.HDD);

        return new Computer.Builder()
                .computerGraphicsCard(graphicsCard)
                .computerStorageDevice(storageDevice)
                .computerRAM(ram)
                .CPUComputer(cpu)
                .computerMonitor(monitor)
                .build();

    }
}
