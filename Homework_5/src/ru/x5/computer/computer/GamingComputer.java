package ru.x5.computer.computer;

import ru.x5.computer.component.Component;
import ru.x5.computer.cpu.CpuFactory;
import ru.x5.computer.graphicscard.GraphicsCardFactory;
import ru.x5.computer.monitor.MonitorFactory;
import ru.x5.computer.ram.RamFactory;
import ru.x5.computer.storagedevice.StorageDeviceFactory;


public class GamingComputer implements ComputerStrategy {
    @Override
    public Computer build() {
        Component cpu = new CpuFactory().createComponent("game");
        Component ram = new RamFactory().createComponent("ddr5");
        Component monitor = new MonitorFactory().createComponent("ips");
        Component graphicsCard = new GraphicsCardFactory().createComponent("DISCRETE");
        Component storageDevice = new StorageDeviceFactory().createComponent("SSD");

        return new Computer.Builder()
                .computerGraphicsCard(graphicsCard)
                .computerStorageDevice(storageDevice)
                .computerRAM(ram)
                .CPUComputer(cpu)
                .computerMonitor(monitor)
                .build();

    }
}
