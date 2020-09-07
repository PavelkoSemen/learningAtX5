package ru.x5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static ru.x5.Utility.isNumber;

/*
    4. Ввести целое число в консоли. Если оно является
    положительным, то прибавить к нему 1; если
    отрицательным, то вычесть из него 2; если нулевым,
    то заменить его на 10. Вывести полученное число
*/
public class MagicNumberChanger {
    public static void main(String[] args) {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            String number;
            do {
                System.out.println("Enter any number");
                number = reader.readLine();

            } while (!isNumber(number));

            System.out.println(changeTheNumber(number));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int changeTheNumber(String stringNumber) {
        int number = Integer.parseInt(stringNumber);
        if (number > 0) {
            return ++number;
        } else if (number < 0) {
            return number - 2;
        }
        return 10;
    }
}
