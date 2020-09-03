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
        shiftZeros(intArrays);
        System.out.println("Everything is the same, only zeros at the end: "+Arrays.toString(intArrays));

    }

    public static void shiftZeros(int[] ints) {

        int lengthArrays = ints.length;

        for (int i = 0; i < lengthArrays; i++) {

            if (ints[i] == 0) {
                for (int j = lengthArrays - 1; j >= 0; j--) {
                    if (i < j && ints[j] != 0) {
                        int tmp = ints[j];
                        ints[j] = ints[i];
                        ints[i] = tmp;
                        lengthArrays -= 1;
                        break;
                    }
                }
            }
        }

    }


}

