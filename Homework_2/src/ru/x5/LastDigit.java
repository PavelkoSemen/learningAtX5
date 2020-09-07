package ru.x5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static ru.x5.Utility.*;

/*
    1. Ввести целое число в консоли и вывести на экран
    последнюю цифру введенного числа.
*/
public class LastDigit {

    public static void main(String[] args) {

        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            String number = reader.readLine();
            if (isNumber(number)) {
                System.out.println(number.charAt(number.length() - 1));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
