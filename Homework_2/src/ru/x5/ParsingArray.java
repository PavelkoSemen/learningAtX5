package ru.x5;

/*
    8. Дан массив целых чисел:
    [1,-10,5,6,45,23,-45,-34,0,32,56,-1,2,-2]. Для данного
    массива найти и вывести на экран:
    - максимальное значение
    - сумму положительных элементов
    - сумму четных отрицательных элементов
    - количество положительных элементов
    - среднее арифметическое отрицательных элементов
*/
public class ParsingArray {

    public static int[] intArrays = new int[]{1, -10, 5, 6, 45, 23, -45, -34, 0, 32, 56, -1, 2, -2};

    public static void main(String[] args) {
        System.out.println("Max value: " + getMaxValue());
        System.out.println("Sum of positive elements: " + sumPositiveElements());
        System.out.println("Sum of even negative elements: " + sumOfEvenNegativeElements());
        System.out.println("Count of positive elements: " + countOfPositiveElements());
        System.out.println("Arithmetic mean: " + arithmeticMean());

    }

    public static int getMaxValue() {
        int maxValue = Integer.MIN_VALUE;

        for (var value : intArrays) {
            if (maxValue < value) {
                maxValue = value;
            }
        }

        return maxValue;

    }

    public static int sumPositiveElements() {
        int sum = 0;

        for (var value : intArrays) {
            if (value > 0) {
                sum += value;
            }
        }

        return sum;
    }

    public static int sumOfEvenNegativeElements() {
        int sum = 0;

        for (var value : intArrays) {
            if (value < 0 && Math.abs(value % 2) == 1) {
                sum += value;
            }
        }

        return sum;
    }

    public static int countOfPositiveElements() {
        int sum = 0;

        for (var value : intArrays) {
            if (value > 0) {
                sum++;
            }
        }

        return sum;
    }

    public static double arithmeticMean() {
        int sum = 0;
        int countElement = 0;

        for (var value : intArrays) {
            if (value < 0) {
                sum += value;
                countElement++;
            }
        }

        return (double) sum / countElement;
    }


}
