package ru.x5.animal;

public class Dog extends Animal  {

    int noseLength;

    public Dog(String food, String location, int noseLength) {
        super(food, location);
        this.noseLength = noseLength;
    }
    public Dog(String food, String location){
        this(food, location, 15);
    }

    public Dog(){
        this("meat", "Street", 15);
    }

    @Override
    public void makeNoise() {
        System.out.println("The dog was awakened by the noise");
    }

    @Override
    public void eat() {
        System.out.println("Dog is eating " + food);
    }
}
