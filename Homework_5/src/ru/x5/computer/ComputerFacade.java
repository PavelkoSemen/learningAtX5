package ru.x5.computer;

import ru.x5.computer.computer.Computer;

public class ComputerFacade {
    public Computer startComputer(Computer computer) {
        computer.getComputerCPU().start();
        computer.getComputerGraphicsCard().start();
        computer.getComputerRAM().start();
        computer.getComputerStorageDevice().start();
        computer.getComputerMonitor().start();
        computer.computerInfo();

        return computer;
    }
}
