package ru.x5.student;

public class Aspirant extends  Student {
    public Aspirant(String firstName, String lastName, double averageMark) {
        super(firstName, lastName, averageMark);
    }

    @Override
    public int getScholarship() {
        if (this.getAverageMark() == 5) {
            return 200;
        }
        return 180;
    }
    @Override
    public String toString() {
        return "Аспирант: " +
                "имя = " + this.getFirstName() +
                ", фамилия = " + this.getLastName() +
                ", средняя оценка = " + this.getAverageMark();
    }
}
