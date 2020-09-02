package ru.x5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static ru.x5.Utility.isNumber;

/*
    5. Ввести три целых числа с консоли. Вывести на
    экран наименьшее из них.
*/
public class MinimumNumber {

    public static void main(String[] args) {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            int arrayLength = 3;
            int[] numbers = new int[arrayLength];
            int countNumber = 0;
            String number;

            while (countNumber != arrayLength) {
                number = reader.readLine();
                if (isNumber(number)) {
                    numbers[countNumber] = Integer.parseInt(number);
                    countNumber += 1;
                }
            }

            System.out.println(getMinimumValue(numbers));


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static int getMinimumValue(int[] numbers) {

        int min = Integer.MAX_VALUE;

        for (var value : numbers) {
            if (min > value) {
                min = value;
            }
        }

        return min;
    }


}
