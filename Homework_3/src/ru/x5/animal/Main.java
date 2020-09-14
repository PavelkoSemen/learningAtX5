package ru.x5.animal;

public class Main {
    public static void main(String[] args) {

        Veterinarian veterinarian = new Veterinarian();

        Animal[] animals = new Animal[]{
                new Cat("mouse", "mountains", 2),
                new Dog("bread", "house", 20),
                new Horse("carrot", "barn", 35)};

        for (Animal animal : animals) {
            veterinarian.treatAnimal(animal);
        }
    }
}