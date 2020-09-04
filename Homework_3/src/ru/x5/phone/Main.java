package ru.x5.phone;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String titleBlank = "Google pixel";
        int countPhone = 3;

        List<Phone> phoneList = new ArrayList<>();
        for (int i = 0; i < countPhone; i++) {

            phoneList.add(new Phone(i, titleBlank + " " + i, i + 10));

        }

        for (Phone phone : phoneList) {
            System.out.println(phone.toString());
        }

        int i = 100;
        for (Phone phone : phoneList) {
            phone.receiveCall("Робот " + i++);
        }

        i = 100;
        for (Phone phone : phoneList) {
            phone.receiveCall("Робот " + i++, i + 100);
        }

        phoneList.get(0).sendMessage(123, 3123, 4145, 123);
        phoneList.get(0).sendMessage(123);
        phoneList.get(0).sendMessage();

    }
}
