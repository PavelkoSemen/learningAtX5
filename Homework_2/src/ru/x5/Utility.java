package ru.x5;

public final class Utility {

    public static boolean isNumber(String stringNumber) {
        try {
            Integer.parseInt(stringNumber);
            return true;
        } catch (NumberFormatException e) {
            System.out.println(String.format("This is not a number: \"%s\".", stringNumber));
        }

        return false;
    }
}
