package ru.x5.computer;


import ru.x5.computer.cpu.CPU;
import ru.x5.computer.cpu.CPUImpl;
import ru.x5.computer.graphicscard.*;
import ru.x5.computer.monitor.Monitor;
import ru.x5.computer.monitor.MonitorImpl;
import ru.x5.computer.ram.RAM;
import ru.x5.computer.ram.RAMImpl;
import ru.x5.computer.storagedevice.*;

public class ComputerFacade {
    public Computer baseComputer() {
        CPU cpu = new CPUImpl.Builder("AMD", "Ryzen 7")
                .numberOfCores(8)
                .clockFrequency(7)
                .cash(1028)
                .build();
        RAM ram = new RAMImpl.Builder("Samsung")
                .memoryCount(2048)
                .typeMemory("DDR 5")
                .RAMFrequency(7)
                .build();
        Monitor monitor = new MonitorImpl.Builder("LG")
                .screenMatrices("IPS")
                .diagonal(24)
                .build();
        GraphicsCard graphicsCard = createGraphicsCard(TypeGraphicsCard.DISCRETE);
        graphicsCard.setCooling(new PassiveCooling());
        StorageDevice storageDevice = createStorageDevice(TypeStorageDevice.INTERNAL);
        storageDevice.setTypeStorageDevice(new SSD());

        return new Computer.Builder()
                .computerGraphicsCard(graphicsCard)
                .computerStorageDevice(storageDevice)
                .computerRAM(ram)
                .CPUComputer(cpu)
                .computerMonitor(monitor)
                .build();

    }

    private GraphicsCard createGraphicsCard(TypeGraphicsCard typeGraphicsCard) {
        GraphicsCardFactory graphicsCardFactory = null;
        switch (typeGraphicsCard) {
            case DISCRETE:
                graphicsCardFactory = new DiscreteGraphicsCardFactory();
                break;
            case INTEGRATED:
                graphicsCardFactory = new IntegratedGraphicsCardFactory();
                break;
            default:
                throw new IllegalArgumentException("Несуществующий тип карты");
        }

        return graphicsCardFactory.createGraphicsCard();

    }

    private StorageDevice createStorageDevice(TypeStorageDevice typeStorageDevice) {
        StorageDeviceFactory deviceFactory = null;
        switch (typeStorageDevice) {
            case EXTERNAL:
                deviceFactory = new ExternalStorageDeviceFactory();
                break;
            case INTERNAL:
                deviceFactory = new InternalStorageDeviceFactory();
                break;
            default:
                throw new IllegalArgumentException("Несуществующий тип носителя");
        }

        return deviceFactory.createStorageDevice();
    }

}
