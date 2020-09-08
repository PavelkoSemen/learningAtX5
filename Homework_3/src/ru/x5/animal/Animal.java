package ru.x5.animal;

public class Animal {
    protected String food;
    protected String location;

    public Animal() {

    }

    public Animal(String food, String location) {
        this.food = food;
        this.location = location;
    }

    public void makeNoise() {
        System.out.println("The animal was awakened by the noise");
    }

    public void eat() {
        System.out.println("Animal is eating " + food);
    }

    public void sleep() {
        System.out.println(this.getClass().getSimpleName() + " sleep");
    }

    public String getFood() {
        return food;
    }

    public String getLocation() {
        return location;
    }
}
