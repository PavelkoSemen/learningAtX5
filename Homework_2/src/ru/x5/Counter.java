package ru.x5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static ru.x5.Utility.isNumber;

/*
    3. Ввести целое число в консоли. Если оно является
    положительным, то прибавить к нему 1, в противном
    случае не изменять его. Вывести полученное число
*/
public class Counter {
    public static void main(String[] args) {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            String number;
            do {
                System.out.println("Enter any number");
                number = reader.readLine();

            } while (!isNumber(number));

            System.out.println(increaseInTheNumber(number));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static int increaseInTheNumber(String stringNumber) {
        int number = Integer.parseInt(stringNumber);
        if (number > 0) {
            return ++number;
        }
        return number;
    }


}
