package ru.x5.phone;

public class Phone {
    private int number;
    private int weight;
    private String model;

    public Phone() {
        this.number = 999;
        this.model = "default phone";
    }

    public Phone(int number, String model) {
        this.number = number;
        this.model = model;
    }

    public Phone(int number, String model, int weight) {
        this(number, model);
        this.weight = weight;

    }

    public void receiveCall(String name) {
        System.out.println("Звонит " + name);
    }

    public void receiveCall(String name, int number) {
        System.out.println(String.format("Звонит %s с номера %d", name, number));
    }

    public void sendMessage(int... numbers) {
        StringBuilder stringBuilder = new StringBuilder();

        if (numbers.length == 0) {
            stringBuilder.append("Номера не заданы");
        } else if (numbers.length == 1) {
            stringBuilder.append("Отправить смс на номер: ");
            stringBuilder.append(numbers[0]);
        } else {
            stringBuilder.append("Отправить смс на номера: ");
            for (int number : numbers) {
                stringBuilder.append(number);
                stringBuilder.append(" ");
            }

        }

        System.out.println(stringBuilder.toString());

    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Телефон{" +
                "номер=" + number +
                ", вес=" + weight +
                ", модель='" + model + '\'' +
                '}';
    }
}
