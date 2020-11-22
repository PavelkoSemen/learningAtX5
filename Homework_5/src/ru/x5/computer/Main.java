package ru.x5.computer;

import ru.x5.computer.computer.ComputerShop;
import ru.x5.computer.computer.Computer;
import ru.x5.computer.computer.GamingComputer;

public class Main {

    public static void main(String[] args) {
        ComputerShop computerShop = new ComputerShop();
        computerShop.setComputerStrategy(new GamingComputer());
        Computer gamingComputer = new ComputerFacade().startComputer(computerShop.build());
    }
}