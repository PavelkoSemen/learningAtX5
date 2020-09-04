package ru.x5.student;
/*
Создайте пример наследования, реализуйте класс Student и класс
Aspirant, аспирант отличается от студента наличием некой научной
работы.
∎ Класс Student содержит переменные: String firstName, lastName,
group. А также double averageMark, содержащую среднюю оценку.
∎ Создать переменную типа Student, которая ссылается на объект
типа Aspirant.
∎ Создать метод getScholarship() для класса Student, который
возвращает сумму стипендии. Если средняя оценка студента равна
5, то сумма 100, иначе 80. Переопределить этот метод в классе
Aspirant. Если средняя оценка аспиранта равна 5, то сумма 200,
иначе 180.
∎ Создать массив типа Student, содержащий объекты класса
Student и Aspirant. Вызвать метод getScholarship() для каждого
элемента массива.
*/


public class Student {
    private String firstName;
    private String lastName;
    private double averageMark;

    public Student(String firstName, String lastName, double averageMark) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.averageMark = averageMark;
    }

    public int getScholarship() {
        if(averageMark == 5){
            return 100;
        }
        return 80;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(double averageMark) {
        this.averageMark = averageMark;
    }

    @Override
    public String toString() {
        return "Студент: " +
                "имя = " + firstName +
                ", фамилия = " + lastName +
                ", средняя оценка = " + averageMark;
    }
}
