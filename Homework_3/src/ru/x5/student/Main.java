package ru.x5.student;

public class Main {
    public static void main(String[] args) {
        Student[] students = new Student[]{
                new Student("Semen", "Pavelko", 3),
                new Aspirant("Andrey", "Yan", 5),
                new Student("Philip", "Dick", 5),
                new Aspirant("Denis", "Villeneuve", 4)};

        for (Student student : students){
            System.out.println(student.toString()+" стипендия " + student.getScholarship());
        }
    }
}
