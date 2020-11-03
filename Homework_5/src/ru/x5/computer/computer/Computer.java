package ru.x5.computer.computer;

import ru.x5.computer.component.Component;
import ru.x5.computer.graphicscard.GraphicsCard;
import ru.x5.computer.storagedevice.StorageDevice;

public class Computer {
    private Component computerCPU;
    private Component computerGraphicsCard;
    private Component computerMonitor;
    private Component computerRAM;
    private Component computerStorageDevice;

    public Computer(Builder builder) {
        this.computerCPU = builder.computerCPU;
        this.computerGraphicsCard = builder.computerGraphicsCard;
        this.computerMonitor = builder.computerMonitor;
        this.computerRAM = builder.computerRAM;
        this.computerStorageDevice = builder.computerStorageDevice;
    }

    public Component getComputerCPU() {
        return computerCPU;
    }

    public Component getComputerGraphicsCard() {
        return computerGraphicsCard;
    }

    public Component getComputerMonitor() {
        return computerMonitor;
    }

    public Component getComputerRAM() {
        return computerRAM;
    }

    public Component getComputerStorageDevice() {
        return computerStorageDevice;
    }

    public void computerInfo() {
        System.out.println("Компьютер: " + "\n" +
                this.computerCPU.getInfo() + "\n" +
                this.computerGraphicsCard.getInfo() + "\n" +
                this.computerRAM.getInfo() + "\n" +
                this.computerStorageDevice.getInfo() + "\n" +
                this.computerMonitor.getInfo());
    }


    public static class Builder {
        private Component computerCPU;
        private Component computerGraphicsCard;
        private Component computerMonitor;
        private Component computerRAM;
        private Component computerStorageDevice;

        public Builder CPUComputer(Component computerCPU) {

            this.computerCPU = computerCPU;
            return this;
        }

        public Builder computerGraphicsCard(Component computerGraphicsCard) {
            this.computerGraphicsCard = computerGraphicsCard;
            return this;
        }

        public Builder computerRAM(Component computerRAM) {
            this.computerRAM = computerRAM;
            return this;
        }

        public Builder computerStorageDevice(Component computerStorageDevice) {
            this.computerStorageDevice = computerStorageDevice;
            return this;
        }

        public Builder computerMonitor(Component computerMonitor) {
            this.computerMonitor = computerMonitor;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}