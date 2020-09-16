package ru.x5.calculator.factorymethod;

public class ConsoleLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println(String.format("ConsoleLogger – Log into file: {%s}", message));
    }
}
