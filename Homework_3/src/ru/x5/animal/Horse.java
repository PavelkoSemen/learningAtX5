package ru.x5.animal;

public class Horse extends Animal {

    int maneLength;

    public Horse(String food, String location, int maneLength) {
        super(food, location);
        this.maneLength = maneLength;
    }
    public Horse(String food, String location){
        this(food, location, 40);
    }

    public Horse(){
        this("grass", "Street", 40);
    }

    @Override
    public void makeNoise() {
        System.out.println("The horse was awakened by the noise");
    }

    @Override
    public void eat() {
        System.out.println("Horse is eating " + food);
    }
}
