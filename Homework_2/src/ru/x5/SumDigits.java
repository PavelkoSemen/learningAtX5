package ru.x5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static ru.x5.Utility.isNumber;

public class SumDigits {
    /*
        2. Ввести целое трехзначное число в консоли и найти
        сумму цифр этого трехзначного числа
    */
    public static void main(String[] args) {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            String number;

            do {

                System.out.println("Enter a number with three digits");

                number = reader.readLine();

            } while (!isNumber(number) || number.length() != 3);

            System.out.println(summingEachValue(number));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static int summingEachValue(String number) {
        int sum = 0;
        for (int i = 0; i < number.length(); i++) {
            sum += Character.getNumericValue(number.charAt(i));
        }

        return sum;
    }

}
