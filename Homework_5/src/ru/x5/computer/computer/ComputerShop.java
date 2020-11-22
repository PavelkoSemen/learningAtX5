package ru.x5.computer.computer;

public class ComputerShop {
    ComputerStrategy computerStrategy;

    public Computer build(){
        return computerStrategy.build();
    }

    public void setComputerStrategy(ComputerStrategy computerStrategy) {
        this.computerStrategy = computerStrategy;
    }
}
