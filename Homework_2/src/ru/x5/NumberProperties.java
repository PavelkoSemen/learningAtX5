package ru.x5;

/*
    6. Ввести целое число в консоли. Вывести его строкуописание вида «отрицательное четное число»,
    «нулевое число», «положительное нечетное число» и
    т. д.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static ru.x5.Utility.isNumber;

public class NumberProperties {
    public static void main(String[] args) {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            String number;
            do {
                System.out.println("Enter any number");
                number = reader.readLine();

            } while (!isNumber(number));

            System.out.println(getPropertiesNumber(number));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getPropertiesNumber(String stringNumber) {

        StringBuilder properties = new StringBuilder();
        int number = Integer.parseInt(stringNumber);

        if (number == 0) {
            return "Нулевое число";
        }

        if (number < 0) {
            properties.append("Отрицательное");
        } else {
            properties.append("Положительное");
        }

        properties.append(" ");

        if ((Math.abs(number % 2)) == 1) {
            properties.append("нечетное число");
        } else {
            properties.append("четное число");
        }

        return properties.toString();
    }


}
