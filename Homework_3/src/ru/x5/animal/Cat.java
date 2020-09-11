package ru.x5.animal;

public class Cat extends Animal {
    // Так и не нашел отличий между кошками и собаками, вспомнил что у кошек 9 жизней:D
    private int countLife;

    public Cat(String food, String location, int countLife) {
        super(food, location);
        this.countLife = countLife;
    }
    public Cat(String food, String location){
        this(food, location, 9);
    }

    public Cat(){
        this("kitekat", "Home", 9);
    }

    @Override
    public void makeNoise() {
        System.out.println("The cat was awakened by the noise");
    }

    @Override
    public void eat() {
        System.out.println("Cat is eating " + food);
    }

    public int getCountLife() {
        return countLife;
    }
}
