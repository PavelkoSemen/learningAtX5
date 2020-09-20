package ru.x5.fruitbasket;

public class Orange extends Fruit {
    public Orange() {
        super(1.5f);
    }

    @Override
    public void info() {
        System.out.println("Типичный кислый апельсин");
    }
}
