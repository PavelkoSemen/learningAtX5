package ru.x5.calculator;

import ru.x5.calculator.factorymethod.Logger;

public class CalculatorImpl implements Calculator {

    private Logger logger;

    public CalculatorImpl(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void sum(double firstValue, double secondValue) {
        double result = firstValue + secondValue;
        logger.log(Double.toString(result));
    }

    @Override
    public void subtraction(double firstValue, double secondValue) {
        double result = firstValue - secondValue;
        logger.log(Double.toString(result));
    }

    @Override
    public void multiplication(double firstValue, double secondValue) {
        double result = firstValue * secondValue;
        logger.log(Double.toString(result));
    }

    @Override
    public void division(double firstValue, double secondValue) {
        double result = firstValue / secondValue;
        logger.log(Double.toString(result));
    }
}
