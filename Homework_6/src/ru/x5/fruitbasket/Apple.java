package ru.x5.fruitbasket;

public class Apple extends Fruit {
    public Apple() {
        super(1.0f);
    }

    @Override
    public void info() {
        System.out.println("Ну это же яблоко");
    }
}

