package ru.x5;

import java.util.Arrays;

/*
    10. Дан массив целых чисел:
    [15,10,0,-6,-5,3,0,-34,0,32,56,0,24,-52]. Переместить
    нули в конец массива. Вывести результат в консоль
*/
public class ShiftZeroInArrays {
    public static void main(String[] args) {
        int[] intArrays = new int[]{15, 10, 0, -6, -5, 3, 0, -34, 0, 32, 56, 0, 24, -52};
        shiftZerosTrue(intArrays);
        System.out.println("Everything is the same, only zeros at the end: " + Arrays.toString(intArrays));
    }

    public static void shiftZerosTrue(int[] ints) {

        int lengthArrays = ints.length - 1;

        for (int i = 0; i <= lengthArrays; i++) {

            lengthArrays = getIndexWithoutZero(ints, lengthArrays);

            if (ints[i] == 0 && i < lengthArrays) {

                int tmp = ints[lengthArrays];
                ints[lengthArrays] = ints[i];
                ints[i] = tmp;
            }
        }
    }

    private static int getIndexWithoutZero(int[] ints, int currentIndex) {

        for (int i = currentIndex; i >= 0; i--) {

            if (ints[i] != 0) {
                return i;
            }
        }
        return Integer.MIN_VALUE;
    }
}

