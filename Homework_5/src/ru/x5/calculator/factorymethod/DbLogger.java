package ru.x5.calculator.factorymethod;

public class DbLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println(String.format("DbLogger – Log into file: {%s}", message));
    }
}
