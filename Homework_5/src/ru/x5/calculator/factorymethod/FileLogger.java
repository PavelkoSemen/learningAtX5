package ru.x5.calculator.factorymethod;

public class FileLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println(String.format("FileLogger – Log into file: {%s}", message));
    }
}
