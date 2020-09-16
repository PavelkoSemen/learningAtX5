package ru.x5.calculator.factorymethod;

public class LoggerFactory {
    public static Logger getConfiguration(TypeLogger typeLogger) {
        switch (typeLogger) {
            case DB:
                return new DbLogger();
            case FILE:
                return new FileLogger();
            case CONSOLE:
                return new ConsoleLogger();
        }
        throw new IllegalArgumentException("unknown param:" + typeLogger);
    }
}
