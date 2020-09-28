package ru.x5.fruitbasket;

public class Main {
    public static void main(String[] args) {
        Box<Orange> orangeBox = new Box<>();
        orangeBox.add(new Orange());
        orangeBox.add(new Orange());
        System.out.println("orangeBox.getWeight(): " + orangeBox.getWeight());

        Box<Apple> appleBox = new Box<>();
        appleBox.add(new Apple());
        appleBox.add(new Apple());
        appleBox.add(new Apple());
        System.out.println("appleBox.compare(orangeBox): " + appleBox.compare(orangeBox));

        Box<Orange> orangeBox1 = new Box<>();
        orangeBox1.add(new Orange());
        System.out.println("orangeBox.getWeight(): " + orangeBox.getWeight());
        System.out.println("orangeBox1.getWeight(): " + orangeBox1.getWeight());

        orangeBox.toLeftBox(orangeBox1);
        System.out.println("orangeBox.getWeight(): " + orangeBox.getWeight());
        System.out.println("orangeBox1.getWeight(): " + orangeBox1.getWeight());

        orangeBox.toRightBox(orangeBox1);
        System.out.println("orangeBox.getWeight(): " + orangeBox.getWeight());
        System.out.println("orangeBox1.getWeight(): " + orangeBox1.getWeight());
    }
}
