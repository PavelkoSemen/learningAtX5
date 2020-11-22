package ru.x5.computer.computer;

import ru.x5.computer.component.Component;
import ru.x5.computer.cpu.CpuFactory;
import ru.x5.computer.graphicscard.GraphicsCardFactory;
import ru.x5.computer.monitor.MonitorFactory;
import ru.x5.computer.ram.RamFactory;
import ru.x5.computer.storagedevice.StorageDeviceFactory;

public class OfficeComputer implements ComputerStrategy {
    @Override
    public Computer build() {
        Component cpu = new CpuFactory().createComponent("server");
        Component ram = new RamFactory().createComponent("ddr4");
        Component monitor = new MonitorFactory().createComponent("tn");
        Component graphicsCard = new GraphicsCardFactory().createComponent("INTEGRATED");
        Component storageDevice = new StorageDeviceFactory().createComponent("HDD");

        return new Computer.Builder()
                .computerGraphicsCard(graphicsCard)
                .computerStorageDevice(storageDevice)
                .computerRAM(ram)
                .CPUComputer(cpu)
                .computerMonitor(monitor)
                .build();

    }
}
