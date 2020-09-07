package ru.x5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
    7. Написать программу, вычисляющую стоимость 10
    минутного междугороднего разговора в зависимости
    от кода города.
*/
public class LandlinePhone {

    public static void main(String[] args) {

        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            String code;
            int talkTime = 10;

            do {
                System.out.println("Enter city code: 905(Moscow), 194(Rostov), 491(Krasnodar), 800(Kirov)");
                code = reader.readLine();

            } while (!(tariffCost(code) != -1));

            System.out.println(tariffCost(code) * talkTime);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static double tariffCost(String tariffName) {

        switch (tariffName) {
            case "905":
                return 4.15;
            case "194":
                return 1.98;
            case "491":
                return 2.69;
            case "800":
                return 5.00;
            default:
                return -1;
        }
    }
}
