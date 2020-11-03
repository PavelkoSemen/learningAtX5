package ru.x5.computer;

import ru.x5.computer.computer.BuildComputer;
import ru.x5.computer.computer.Computer;
import ru.x5.computer.computer.GamingComputer;

public class Main {

    public static void main(String[] args) {
        BuildComputer buildComputer = new BuildComputer();
        buildComputer.setComputerStrategy(new GamingComputer());
        Computer gamingComputer = new ComputerFacade().startComputer(buildComputer.build());
    }
}
