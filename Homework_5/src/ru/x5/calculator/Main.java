package ru.x5.calculator;

import ru.x5.calculator.factorymethod.Logger;
import ru.x5.calculator.factorymethod.LoggerFactory;
import ru.x5.calculator.factorymethod.TypeLogger;

public class Main {

    public static void main(String[] args) {
        Logger logger;
        logger = LoggerFactory.getConfiguration(TypeLogger.CONSOLE);
        Calculator calculator1 = new CalculatorImpl(logger);
        calculator1.sum(2, 3);
        logger = LoggerFactory.getConfiguration(TypeLogger.DB);
        Calculator calculator2 = new CalculatorImpl(logger);
        calculator2.multiplication(5, 4);
    }
}
