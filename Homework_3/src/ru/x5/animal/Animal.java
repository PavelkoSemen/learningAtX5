package ru.x5.animal;

public class Animal {
    private String food;
    private String location;

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
        System.out.println(this.getClass().getSimpleName()+ " is eating " + food);
    }

    public void sleep() {
        System.out.println("Sleep");
    }

    public String getFood() {
        return food;
    }

    public String getLocation() {
        return location;
    }
}
