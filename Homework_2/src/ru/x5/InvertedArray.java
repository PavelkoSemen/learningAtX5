package ru.x5;

import java.util.Arrays;

/*
    9. Дан массив целых чисел:
    [15,10,51,-6,-5,3,-10,-34,0,32,56,-12,24,-52].
    Переставить элементы массива в обратном порядке.
    Вывести результат в консоль
*/
public class InvertedArray {
    public static void main(String[] args) {

        int[] intArrays = new int[]{15, 10, 51, -6, -5, 3, -10, -34, 0, 32, 56, -12, 24, -52};

        System.out.println("Inverted array: " + Arrays.toString(reverse(intArrays)));

    }

    public static int[] reverse(int[] ints) {

        int[] reversArrays = new int[ints.length];

        for (int i = 0; i < ints.length; i++) {

            reversArrays[ints.length - 1 - i] = ints[i];

        }

        return reversArrays;
    }
}
