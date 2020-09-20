package ru.x5.fruitbasket;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Box<Orange> orangeBox = new Box<>();
        orangeBox.add(new Orange());
        orangeBox.add(new Orange());
        System.out.println(orangeBox.getWeight());

        Box<Apple> appleBox = new Box<>();
        appleBox.add(new Apple());
        appleBox.add(new Apple());
        appleBox.add(new Apple());
        System.out.println(appleBox.compare(orangeBox));


        Box<Orange> orangeBox1 = new Box<>();
        orangeBox.add(new Orange());
        orangeBox.addBox(orangeBox1);

        System.out.println(orangeBox.getWeight());

        System.out.println(orangeBox1.getWeight());

    }
}
