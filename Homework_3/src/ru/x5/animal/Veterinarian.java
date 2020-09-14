package ru.x5.animal;

public class Veterinarian {
    public void treatAnimal(Animal animal) {
        System.out.println(animal.getClass().getSimpleName() +
                " eat " + animal.getFood() +
                " location " + animal.getLocation());
    }
}