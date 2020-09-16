package ru.x5.computer;

import ru.x5.computer.cpu.CPU;
import ru.x5.computer.graphicscard.GraphicsCard;
import ru.x5.computer.monitor.Monitor;
import ru.x5.computer.ram.RAM;
import ru.x5.computer.storagedevice.StorageDevice;

public class Computer {
    private CPU computerCPU;
    private GraphicsCard computerGraphicsCard;
    private Monitor computerMonitor;
    private RAM computerRAM;
    private StorageDevice computerStorageDevice;

    public Computer(Builder builder) {
        this.computerCPU = builder.computerCPU;
        this.computerGraphicsCard = builder.computerGraphicsCard;
        this.computerMonitor = builder.computerMonitor;
        this.computerRAM = builder.computerRAM;
        this.computerStorageDevice = builder.computerStorageDevice;
    }

    public void computerInfo() {
        System.out.println("Компьютер: " + "\n" +
                this.computerCPU.CPUInfo() + "\n" +
                this.computerGraphicsCard.cardInfo() + "\n" +
                this.computerRAM.RAMInfo() + "\n" +
                this.computerStorageDevice.storageDeviceInfo() + "\n" +
                this.computerMonitor.monitorInfo());
    }

    public static class Builder {
        private CPU computerCPU;
        private GraphicsCard computerGraphicsCard;
        private Monitor computerMonitor;
        private RAM computerRAM;
        private StorageDevice computerStorageDevice;

        public Builder CPUComputer(CPU computerCPU) {
            this.computerCPU = computerCPU;
            return this;
        }

        public Builder computerGraphicsCard(GraphicsCard computerGraphicsCard) {
            this.computerGraphicsCard = computerGraphicsCard;
            return this;
        }

        public Builder computerRAM(RAM computerRAM) {
            this.computerRAM = computerRAM;
            return this;
        }

        public Builder computerStorageDevice(StorageDevice computerStorageDevice) {
            this.computerStorageDevice = computerStorageDevice;
            return this;
        }

        public Builder computerMonitor(Monitor computerMonitor) {
            this.computerMonitor = computerMonitor;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}
